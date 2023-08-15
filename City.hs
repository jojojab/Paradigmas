module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
nameC :: City -> String
distanceC :: City -> City -> Float

newC name point = Cit name point
nameC (Cit name point) = name
distanceC (Cit name1 point1) (Cit name2 point2) = difP point1 point2

p1 = newP 1 1
ciudad1 = Cit "hola" p1
p2 = newP 2 2
ciudad2 = Cit "igna" p2
disC1C2 = distanceC ciudad1 ciudad2