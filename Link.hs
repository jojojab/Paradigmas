module Link ( Link, newL, linksL, connectsL, capacityL, delayL )
   where

import Point
import City
import Quality

data Link = Lin City City Quality deriving (Eq, Show)

newL :: City -> City -> Quality -> Link -- genera un link entre dos ciudades distintas
connectsL :: City -> Link -> Bool   -- indica si esta ciudad es parte de este link
linksL :: City -> City -> Link -> Bool -- indica si estas dos ciudades distintas estan conectadas mediante este link
capacityL :: Link -> Int
delayL :: Link -> Float     -- la demora que sufre una conexion en este canal

newL city1 city2 qual = Lin city1 city2 qual
connectsL cityIn (Lin city1 city2 qual) | cityIn == city1 || cityIn == city2 = True
                                        | otherwise = False
linksL city1 city2 (Lin city3 city4 qual) | (city1 == city3 && city2 == city4) || (city1 == city4 && city2 == city3) = True
                                          | otherwise = False

capacityL = undefined
delayL = undefined


p1 = newP 1 1
ciudad1 = newC "hola" p1
p2 = newP 2 2
ciudad2 = newC "chau" p2
qual1 = newQ "pepe" 10 3
link1 = Lin ciudad1 ciudad2 qual1

p3 = newP 4 4
ciudad3 = newC "juan" p3
connect1 = connectsL ciudad1 link1
connect2 = connectsL ciudad3 link1

link2 = linksL ciudad1 ciudad2 link1
link3 = linksL ciudad2 ciudad1 link1
link4 = linksL ciudad3 ciudad2 link1