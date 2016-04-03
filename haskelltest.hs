import System.IO

factorial n = if n == 0 then 1 else n * factorial (n - 1)

main :: IO ()
main = do
 print(replicate 1000000 (factorial(25 :: Integer)))