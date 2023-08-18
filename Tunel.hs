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
                          | (cityInTunel city1 city2 tun) == False = error "At least one city not in tunel"
                          | otherwise = True
                        --   | otherwise foldr(\each fold -> if )


cityInTunel :: City -> City -> Tunel -> Bool
cityInTunel city1 city2 (Tun (tun : tunvs)) = connectsL city1 tun && connectsL city2 tun

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
con1 = connectsT ciudad1 ciudad2 tunel1
con2 = connectsT ciudad1 ciudad3 tunel1

{-

combinations :: [a] -> [[a]]
combinations xs = foldr combine [[]] xs
    where
        combine x acc = [ y | y <- acc, y' <- [x]:y ]

-}