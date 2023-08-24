{-# OPTIONS_GHC -Wno-unrecognised-pragmas #-}
{-# HLINT ignore "Redundant if" #-}
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
foundR (Reg citys links tunels) newCity = Reg (citys ++ [newCity]) links tunels

cityInRegion :: City -> Region -> Bool
cityInRegion city (Reg [] _ _) = False
cityInRegion city (Reg (citys : cityvs) a b) = (city == citys) || cityInRegion city (Reg cityvs a b)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg citys links tunels) city1 city2 qua
   | city1 == city2 = error "Same city"
   | length citys <= 1 = error "Insufficient amount of citys in region for a link"
   | not (cityInRegion city1 (Reg citys links tunels)) || not (cityInRegion city2 (Reg citys links tunels)) = error "At least one city not in region"
   | otherwise = Reg citys (links ++ [newL city1 city2 qua]) tunels --Enlce de las ciudades 

cityToConnections :: [City] -> [Link] -> [Bool]
cityToConnections [] _ = []
cityToConnections [x] _ = []
cityToConnections (x:y:ys) links = (linkIn (x,y) links) : cityToConnections (y:ys) links

linkIn :: (City,City) -> [Link] -> Bool
linkIn (c1,c2) links = foldr (\each fold -> if linksL c1 c2 each then True else fold) False links

isAll target = foldr (\each -> (&&) $ target == each) True

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR (Reg citys links tunels) ciudades | length ciudades <= 1 = error "Insufficient amount of citys in region for a tunel"
                                         | not (isAll True (cityToConnections ciudades links)) = error "Not all cities are connected"
                                         | otherwise = Reg citys links (tunels ++ [newT [newL c1 c2 qua1, newL c2 c3 qua1]])

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR = undefined

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR = undefined

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR = undefined

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR = undefined


c1 = newC "pepe" (newP 1 1)
c2 = newC "tilin" (newP 2 2)
c3 = newC "juan" (newP 3 3)
c4 = newC "chino" (newP 4 4)
c5 = newC "nombre" (newP 5 5)
c6 = newC "BsAs" (newP 6 6)

l1 = newL c1 c2 qua1 
l2 = newL c2 c3 qua1
l3 = newL c3 c4 qua1

qua1 = newQ "naaa" 10 10

region1 = Reg [c1,c2,c3] [l1, l2, l3] []
region2 = Reg [c1, c4] [] []
region3 = Reg [c2, c3] [] []




linksTrue = [newL c1 c2 qua1, newL c2 c3 qua1, newL c3 c4 qua1, newL c4 c1 qua1]
linksFalse = [newL c1 c2 qua1, newL c2 c3 qua1, newL c3 c1 qua1]
linE1 = cityToConnections [c1,c2,c3] linksTrue
linE2 = cityToConnections [c1,c2,c4] linksFalse
linkPepe = [newL c1 c3 qua1, newL c3 c2 qua1, newL c1 c2 qua1]
linkQuavo = [newL c1 c3 qua1, newL c3 c2 qua1, newL c2 c4 qua1]
linE3 = cityToConnections [c1, c2] linkPepe
linE4 = cityToConnections [c1, c2] linkQuavo 


linkeado = [newL c1 c3 qua1, newL c3 c5 qua1, newL c2 c3 qua1]
linE5 = cityToConnections [c1, c2, c3, c4, c5, c6] linkeado -- [False, True, False, False, False, False]
linkeado2 = [newL c1 c2 qua1, newL c3 c4 qua1, newL c5 c6 qua1]
linE6 = cityToConnections [c1, c2, c3, c4, c5, c6] linkeado2 -- [True, False, True, False, True]