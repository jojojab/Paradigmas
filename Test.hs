import Control.Exception
import System.IO.Unsafe


import Point
import City
import Quality
import Link
import Tunel
import Region

testF :: Show a => a -> Bool
testF action = unsafePerformIO $ do
    result <- tryJust isException (evaluate action)
    return $ case result of
        Left _ -> True
        Right _ -> False
    where
        isException :: SomeException -> Maybe ()
        isException _ = Just ()

result :: Int -> Int
result x | x > 5 = 4
         | otherwise = error "hey"

-- ahora pueden evaluar
t = [ testF (result 0 ),
      testF (result 6 ) ]


-- modulo Point

p1 = newP 1 1
p2 = newP 4 4
p3 = newP 10 10
difP1P2 = difP p1 p2
difP1P3 = difP p1 p3
difP2P3 = difP p2 p3

-- modulo City

c1 = newC "BsAs" p1
c2 = newC "Tokyo" p2
c3 = newC "New York" p3

nameC1 = nameC c1
nameC2 = nameC c2
nameC3 = nameC c3

disC1C2 = distanceC c1 c2
disC1C3 = distanceC c1 c3
disC2C3 = distanceC c2 c3

-- modulo Quality

q1 = newQ "low" 10 3
q2 = newQ "medium" 20 5
q3 = newQ "high" 30 10

capq1 = capacityQ q1
capq2 = capacityQ q2
capq3 = capacityQ q3

delq1 = delayQ q1
delq2 = delayQ q2
delq3 = delayQ q3

-- modulo Link

l1 = newL c1 c2 q1
l2 = newL c2 c3 q2
l3 = newL c3 c1 q3

conC1L1 = connectsL c1 l1
conC2L1 = connectsL c2 l1
conC3L1 = connectsL c3 l1
conC2L2 = connectsL c2 l2
conC3L2 = connectsL c3 l2
conC1L2 = connectsL c1 l2

c1c2L1 = linksL c1 c2 l1
c2c1L1 = linksL c2 c1 l1
c3L1 = linksL c1 c3 l1

capL1 = capacityL l1
capL2 = capacityL l2
capL3 = capacityL l3

delL1 = delayL l1
delL2 = delayL l2
delL3 = delayL l3

-- modulo Tunel

t1 = newT [l1,l2]
t2 = newT [l3,l1]
t3 = newT [l2,l3]

conC1C3T1 = connectsT c1 c3 t1
conC3C1T1 = connectsT c1 c3 t1
conC2C3T2 = connectsT c2 c3 t2
conC1C3T2 = connectsT c1 c3 t2

usesL1T1 = usesT l1 t1
usesL2T2 = usesT l2 t2
usesL3T3 = usesT l3 t3

delT1 = delayT t1
delT2 = delayT t2
delT3 = delayT t3