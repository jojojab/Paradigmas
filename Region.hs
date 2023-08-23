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
cityInRegion city (Reg (citys : cityvs) a b) = if city == citys then True
                                                else cityInRegion city (Reg (cityvs) a b)

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg citys links tunels) city1 city2 qua 
   | city1 == city2 = error "Same city"
   | length citys <= 1 = error "Insufficient amount of citys in region for a link"
   | not (cityInRegion city1 (Reg citys links tunels)) || not (cityInRegion city2 (Reg citys links tunels)) = error "At least one city not in region"
   | otherwise = Reg citys (links ++ [newL city1 city2 qua]) tunels --Enlce de las ciudades 

                                    

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR = undefined

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

qua1 = newQ "naaa" 10 10

region1 = Reg [c1,c2,c3] [] []
region2 = Reg [c1, c4] [] []
region3 = Reg [c2, c3] [] []

cityToConnections :: (Eq a) => [a] -> [(a,a)]
cityToConnections [] = []
cityToConnections [x] = []
cityToConnections (x:y:ys) = (x,y) : cityToConnections (y:ys)

linkExists :: [(City, City)] -> [Link] -> Bool
linkExists [] _ = False
linkExists _ [] = False
linkExists ((city1, city2):cityvs) (links:linkvs) = if connectsL city1 links && connectsL city2 links then True  && linkExists cityvs [links]
                                           else linkExists cityvs linkvs