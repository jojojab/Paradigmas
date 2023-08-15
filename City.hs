module City ( City, newC, nameC, distanceC )
   where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
nameC :: City -> String
distanceC :: City -> City -> Float

newC = undefined
-- newC a (Poi x y) = Cit a (Poi a b)
nameC = undefined
distanceC = undefined

import Point