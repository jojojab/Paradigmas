module Tunel ( Tunel, newT, connectsT, usesT, delayT )
   where

import Link
import Quality
import City
import Point

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
connectsT :: City -> City -> Tunel -> Bool -- inidca si este tunel conceta estas dos ciudades distintas
usesT :: Link -> Tunel -> Bool  -- indica si este tunel atraviesa ese link
delayT :: Tunel -> Float -- la demora que sufre una conexion en este tunel

newT links = Tun links

connectsT city1 city2 tun | city1 == city2 = error "Same city"
                          | firstCity city1 tun && lastCity city2 tun = True
                          | firstCity city2 tun && lastCity city1 tun = True
                          | otherwise = False


-- cityInTunel :: City -> City -> Tunel -> Bool
-- cityInTunel city1 city2 (Tun (tun : tunvs)) = connectsL city1 tun && connectsL city2 tun

firstCity :: City -> Tunel -> Bool
firstCity city (Tun links) = connectsL city (head links) && not (connectsL city (head (tail links)))

lastCity :: City -> Tunel -> Bool
lastCity city (Tun links) = connectsL city (last links) && not (connectsL city (head (init links)))


usesT linkTarget (Tun links) = foldr (\each fold -> if each == linkTarget then True else fold) False links

delayT (Tun links) = foldr (\each fold -> fold + delayL each) 0.0 links 

p1 = newP 1 1
ciudad1 = newC "hola" p1
p2 = newP 2 2
ciudad2 = newC "chau" p2
qual1 = newQ "pepe" 10 3
link1 = newL ciudad1 ciudad2 qual1
p3 = newP 4 8
ciudad3 = newC "jamaica" p3
qual2 = newQ "cuba" 4 2
link2 = newL ciudad2 ciudad3 qual2
qual3 = newQ "panama" 5 10
link3 = newL ciudad3 ciudad1 qual3
tunel1 = Tun [link1, link2]
tunel2 = Tun [link2, link3]

con1 = connectsT ciudad1 ciudad2 tunel1
con2 = connectsT ciudad1 ciudad3 tunel1
con3 = connectsT ciudad3 ciudad1 tunel1

uses1 = usesT link1 tunel1
uses2 = usesT link3 tunel1
uses3 = usesT link3 tunel2

delay1 = delayT tunel1
delay2 = delayT tunel2