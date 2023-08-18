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
connectsT = undefined
usesT = undefined
delayT = undefined

p1 = newP 1 1
ciudad1 = newC "hola" p1
p2 = newP 2 2
ciudad2 = newC "chau" p2
qual1 = newQ "pepe" 10 3
link1 = newL ciudad1 ciudad2 qual1
p3 = newP 4 8
ciudad3 = newC "jamaica" p3
qual2 = newQ "cuba" 4 2
link2 = newL ciudad1 ciudad3 qual2
tunel1 = newT [link1, link2]