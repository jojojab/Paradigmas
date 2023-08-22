module Region ( Region, newR, foundR, linkR, tunelR, pathR, linksForR, connectedR, linkedR, delayR, availableCapacityForR, usedCapacityForR )
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

linkR :: Region -> City -> City -> Quality -> Region -- enlaza dos ciudades de la región con un enlace de la calidad indicada
linkR (Reg citys links tunels) city1 city2 (Qua name tol delay) | --Si las ciudades no estan en la misma region error
                                                                | city1 == city2 = error "Same city"
                                                                | --Enlce de las ciudades

tunelR :: Region -> [ City ] -> Region -- genera una comunicación entre dos ciudades distintas de la región
tunelR = undefined

pathR = undefined
linksForR = undefined

connectedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan conectadas por un tunel
connectedR = undefined

linkedR :: Region -> City -> City -> Bool -- indica si estas dos ciudades estan enlazadas
linkedR = undefined

delayR :: Region -> City -> City -> Float -- dadas dos ciudades conectadas, indica la demora
delayR = undefined

availableCapacityForR :: Region -> City -> City -> Int -- indica la capacidad disponible entre dos ciudades
availableCapacityForR = undefined

usedCapacityForR = undefined