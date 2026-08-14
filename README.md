# 1-javabasics

Welcome! This topic has one or more small Java exercises to work through.

## The exercises

| Exercise | Name | File | Points |
|---|---|---|---|
| 1 | Multiplier | `src/main/java/exercises/Multiplier.java` | 1 |
| 2 | Checker | `src/main/java/exercises/Checker.java` | 1 |
| 3 | Greeting | `src/main/java/exercises/Greeting.java` | 1 |
| 4 | Validator | `src/main/java/exercises/Validator.java` | 1 |
| 5 | Factorial | `src/main/java/exercises/Factorial.java` | 1 |
| 6 | Fibonacci | `src/main/java/exercises/Fibonacci.java` | 1 |

Each exercise has a `TODO` method to fill in, and a matching test file you
can use to check your work as you go. You don't need to touch the test
files — they're just there to help you see how you're doing.

There's also a `Main.java` with a `main` method, so you have something
runnable from the start — it doesn't do anything yet, it's just there so
your "Run" button works right away.

## Exercise descriptions

### 1. Multiplier (1p)

Modify the code, i.e. method `multiply(Integer a, Integer b)` by following
the instructions:

- Multiply the method parameters, i.e. variables `a` and `b`.
- Multiply the product by two.
- Add one to the new product.
- Print the final product to the console.

### 2. Checker (1p)

Modify the code in method `checkNum(Integer num)` to:

- Print out to console string `pos`, if the parameter value is positive.
- Print out to console string `neg`, if the parameter value is negative.
- Print out to console string `zero`, if the parameter equals zero.

### 3. Greeting (1p)

Modify the method `greet(String[] visitors)` to greet visitors whose names
are given in the String array, by printing out to console the message
`Hello name, you are visitor number n` for each of them, where `name` is
the visitor name and `n` is the number of the visitor, starting from 1.

### 4. Validator (1p)

Modify the method `oddOut(Short limit)` to print out all even numbers above
zero until the function parameter `limit`. The numbers are separated by
comma and printed without new line. If the parameter value is zero or less
than zero, print out string `No even numbers to print.` without new line.

Example output, when limit is 9, print out `2,4,6,8`.

### 5. Factorial (1p)

Create a method `factorial(Integer num)` that calculates the factorial of
the parameter `num`, where the value of `num` must be between 1 and 20.
Return the result as type `Long`.

If the value of `num` is less than 1 or larger than 20, the function
returns -1.

Example output when num is 5: `120`

Example output when num is 0: `-1`

### 6. Fibonacci (1p)

Ok, let's next have a bit more complex exercise. Fibonacci sequence is a
well-known sequence of numbers with very interesting properties.

In the sequence, each number is the sum of two preceding numbers, starting
from 0 and 1. So, 1st element is 0, 2nd element is 1, 3rd element is
0+1=1, 4th element is 1+1=2, 5th element is 1+2=3, 6th element is 2+3=5
and so on, resulting 0,1,1,2,3,5,8,13,21,34,...

Your task is to write the algorithm for Fibonacci sequence and find the
nth element in the sequence. Write the algorithm into the class method
`getNumber(Integer n)`, which should return `Integer`.

Some ideas for this task:

- Note that with computers the first element of series has index 0.
- Typically the first two sequence numbers (0 and 1) are predefined, so
  the 3rd element can be calculated easily.
- Maybe use a set of variables to store the preceding values in the
  sequence?
- You could also use a recursive function (a function that calls itself).

In fact, you will need your algorithm implementation in later exercises.

## Step by step

1. **Clone this repo**:
   ```
   git clone <this repo's URL>
   cd <the folder that creates>
   ```
2. **Open it in VS Code**: `code .` (or File → Open Folder). If prompted
   "This workspace has extension recommendations", click **Install** — this
   adds a flask-shaped **Testing** icon to the left sidebar.
3. **Run the tests before changing anything**, just to see where you're
   starting from. Click the flask icon, then the play button at the top of
   the Test Explorer panel — everything will be red at first, and that's
   completely normal.
4. **Implement each exercise** in its source file, one at a time.
5. **Re-run the tests** after each change to see your progress. Prefer a
   terminal? `mvn test` does the same check for all exercises at once.
6. **Work locally** until everything passes.
7. **Push your work back** to the GitHub organization when you're ready:
   ```
   git add -A
   git commit -m "Exercises done"
   git push
   ```
   A quick check runs automatically on GitHub afterward — you can peek at
   it under this repo's **Actions** tab if you're curious, but it's just
   extra feedback, nothing you need to act on.
8. **Assignment completed — good job!**
