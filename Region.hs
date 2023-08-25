module Region ( Region, newR, foundR, linkR, tunelR, connectedR, linkedR, delayR, availableCapacityForR)
   where

import Tunel
import Link
import Quality
import City
import Point

data Region = Reg [City] [Link] [Tunel] deriving Show

newR :: Region
newR = Reg [] [] []

foundR :: Region -> City -> Region -- agrega una nueva ciudad a la región
foundR (Reg cities links tunels) newCity = Reg (cities ++ [newCity]) links tunels

cityInRegion :: City -> Region -> Bool
cityInRegion city (Reg [] _ _) = False
cityInRegion city (Reg (cities : cityvs) a b) = (city == cities) || cityInRegion city (Reg cityvs a b)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg cities links tunels) city1 city2 qua
   | city1 == city2 = error "Same city"
   | length cities <= 1 = error "Insufficient amount of cities in region for a link"
   | not (cityInRegion city1 (Reg cities links tunels)) || not (cityInRegion city2 (Reg cities links tunels)) = error "At least one city not in region"
   | otherwise = Reg cities (links ++ [newL city1 city2 qua]) tunels --Enlce de las ciudades 


linkForTunel :: [City] -> [Link] -> [Link]
linkForTunel [] _ = []
linkForTunel [x] _ = []
linkForTunel (x:y:ys) links = (linkIn (x,y) links) : linkForTunel (y:ys) links

linkIn :: (City,City) -> [Link] -> Link
linkIn (c1,c2) links = foldr (\each fold -> if linksL c1 c2 each then each else fold) noLinkFound links

countA target = foldr (\each fold -> if target == each then fold + 1 else fold) 0

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg cities links tunels) ciudades | length ciudades <= 1 = error "Insufficient amount of cities in region for a tunel"
                                         | countA noLinkFound (linkForTunel cities links) /= 0 = error "Not all cities are connected"
                                         | otherwise = Reg cities links (tunels ++ [newT (linkForTunel cities links)])

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR (Reg cities links tunels) c1 c2 = foldr (\each fold -> if connectsT c1 c2 each then True else fold) False tunels

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR (Reg cities links tunels) c1 c2 = foldr (\each fold -> if linksL c1 c2 each then True else fold) False links

reqTunel :: Region -> City -> City -> Tunel
reqTunel (Reg cities links tunels) c1 c2 = foldr (\each fold -> if connectsT c1 c2 each then each else fold) noTunFound tunels

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR r1@(Reg cities links tunels) c1 c2 | connectedR r1 c1 c2 = delayT (reqTunel r1 c1 c2)
                                       | otherwise = error "Cities not connected"

countLinkuses :: [Tunel] -> Link -> Int
countLinkuses tunels link = foldr (\each fold -> if usesT link each then fold + 1 else fold) 0 tunels



availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR r1@(Reg cities links tunels) c1 c2 = if linkedR r1 c1 c2 then (capacityL (linkIn (c1,c2) links)) - countLinkuses tunels (linkIn (c1,c2) links)
                                                            else error "Cities not linked"


c1 = newC "pepe" (newP 1 1)
c2 = newC "tilin" (newP 2 2)
c3 = newC "juan" (newP 3 3)
c4 = newC "chino" (newP 4 4)
c5 = newC "nombre" (newP 5 5)
c6 = newC "BsAs" (newP 6 6)


l1 = newL c1 c2 qua1 
l2 = newL c2 c3 qua1
l3 = newL c3 c4 qua1
l4 = newL c4 c5 qua1
noLinkFound = newL (newC "noLinkFound" (newP 0 0)) (newC "noLinkFound" (newP 0 0)) (newQ "noLinkFound" 0 0)
noTunFound = newT [noLinkFound]

qua1 = newQ "naaa" 10 10

region1 = Reg [c1,c2,c3,c4] [l1, l2, l3] [tun1,tun2]
region2 = Reg [c1, c4] [] []
region3 = Reg [c2, c3] [] []
region4 = Reg [c1,c2,c3,c4] [l1,l2,l3,l4] []




linksTrue = [newL c1 c2 qua1, newL c2 c3 qua1, newL c3 c4 qua1, newL c4 c1 qua1]
linksFalse = [newL c1 c2 qua1, newL c2 c3 qua1, newL c3 c1 qua1]
linE1 = linkForTunel [c1,c2,c3] linksTrue
linE2 = linkForTunel [c1,c2,c4] linksFalse
linkPepe = [newL c1 c3 qua1, newL c3 c2 qua1, newL c1 c2 qua1]
linkQuavo = [newL c1 c3 qua1, newL c3 c2 qua1, newL c2 c4 qua1]
linE3 = linkForTunel [c1, c2] linkPepe
linE4 = linkForTunel [c1, c2] linkQuavo 


linkeado = [newL c1 c3 qua1, newL c3 c5 qua1, newL c2 c3 qua1]
linE5 = linkForTunel [c1, c2, c3, c4, c5, c6] linkeado
linkeado2 = [newL c1 c2 qua1, newL c3 c4 qua1, newL c5 c6 qua1]
linE6 = linkForTunel [c1, c2, c3, c4, c5, c6] linkeado2

tunr1 = tunelR region1 [c1,c2,c3]
tunr2 = tunelR region1 [c1]
tunr3 = tunelR region1 []
tunr4 = tunelR region3 [c1,c2,c3]
tunr5 = tunelR region4 [c1,c2,c3,c4]

regionPiola = Reg [c1,c2,c3,c4,c5,c6] [l1,l2,l3,l4] [tun1, tun2 ,tun3]

con1 = connectedR region1 c1 c2
con2 = connectedR region1 c1 c4
con3 = connectedR region1 c1 c3

tun1 = newT [l1, l2]
tun2 = newT [l1, l2, l3]
tun3 = newT [l1, l2, l3, l4]