# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## What this repo is

A student exercise template for an OAMK Java course topic ("1-javabasics"),
covering fundamental Java syntax and control flow rather than OOP design.
It has six single-method exercises, each already correctly stubbed
(predefined method signature, `TODO` body throwing
`UnsupportedOperationException`) with a matching JUnit 5 test class — there
is no gap to fill in here, unlike some of the other sibling topic repos:

- **Multiplier** — `multiply(Integer a, Integer b)`: prints `a*b*2 + 1`.
- **Checker** — `checkNum(Integer num)`: prints `pos`/`neg`/`zero`.
- **Greeting** — `greet(String[] visitors)`: prints a numbered greeting per
  visitor.
- **Validator** — `oddOut(Short limit)`: prints even numbers up to `limit`,
  comma-separated, or a message if `limit <= 0`.
- **Factorial** — `factorial(Integer num): Long`: factorial of `num`
  (1–20), or `-1` outside that range.
- **Fibonacci** — `getNumber(Integer n): Integer`: the nth Fibonacci
  number (0-indexed).

The `Fibonacci` algorithm from this topic is reused conceptually in later
topics, per the README.

## Commands

- Run all tests: `mvn test`
- Run a single test class: `mvn test -Dtest=FactorialTest`
- Run a single test method: `mvn test -Dtest=FactorialTest#calculatesFactorialOfFive`
- Compile only: `mvn compile`

Requires JDK 22 (`maven.compiler.release` in `pom.xml`). No linter is
configured.

## Architecture / conventions

- All exercise code lives under the single `exercises` package
  (`src/main/java/exercises`), mirrored 1:1 by test classes in
  `src/test/java/exercises` (e.g. `Factorial.java` ↔ `FactorialTest.java`).
- `Main.java` is a placeholder entry point only, unrelated to the exercises
  themselves — it exists so the IDE's "Run" button works immediately.
- Several exercises (`Checker`, `Greeting`, `Validator`) communicate their
  result via `System.out.println` rather than a return value; their tests
  capture stdout with a `captureOutput`/`captureLines` helper instead of
  asserting on a return value.
- Test files are the source of truth for expected behavior and are restored
  from the canonical upstream template by CI before grading (see below) — do
  not rely on modifying them to make an exercise "pass".

## CI autograding (`.github/workflows/classroom-ci.yml`)

On every push, CI clones the canonical `OAMK-Java-2026/1-javabasics-template`
repo, overwrites the local `src/test` and `points.json` with the canonical
versions, runs `mvn test`, then computes a partial score per test class
(`points * passed/total`, rounded) and posts it as a commit status. This
means:

- Local edits to `src/test/**` or `points.json` have no effect on the graded
  score — only `src/main/java/exercises/**` (or new files there) matter.
- A missing Surefire report for a class (e.g. from a compile error) scores
  that class as 0.

## Reusable recipe: building/updating an exercise-topic repo

This repo is one of a family of sibling OAMK Java course template repos
(`0-helloworld-template`, `1-javabasics-template`, `2-javaoop-template`,
`3-collections-template`, ...), all sharing the same skeleton (`pom.xml`,
`src/main/java/exercises`, `src/test/java/exercises`, `points.json`,
`.vscode`, `.github/workflows/classroom-ci.yml`). When asked to turn a
topic's `assignments_N.txt` (plus any UML/reference images committed
alongside it) into exercise stubs in one of these repos, follow this
recipe:

1. **One class per exercise, named after the concept** (e.g. `Greeting`,
   `Validator`, `Apartment`, `Vehicle`, `Garage`) — not generic
   `Exercise1`/`Exercise2` names — under the shared `exercises` package.
2. **Stub style depends on exercise shape:**
   - *Single-method* exercises (a method body to fill in, signature fixed):
     predefine the exact method signature the tests call, with body
     `// TODO: implement this method so the tests in <Name>Test pass`
     followed by `throw new UnsupportedOperationException("not implemented yet");`.
   - *Full-class-design* exercises (fields + constructor + multiple methods,
     typically driven by a UML diagram): the stub is an **empty class with
     only a single TODO comment** pointing at the spec — no field, no
     constructor, no method signatures. Students design the whole class
     themselves. This means `mvn test` fails with a *compile* error until
     implemented, not a runtime exception — that's the expected "red at
     first" state for this stub style, not a mistake to fix.
3. **Tests**: JUnit 5, one test class per exercise class, must not need
   modification by students. Cover the happy path plus edge cases (zero,
   negative, boundary, empty). For methods that print instead of returning
   a value, capture `System.out` with a small `captureOutput`/`captureLines`
   helper (redirect to a `ByteArrayOutputStream`, restore in `finally`)
   rather than changing the method to return a value.
4. **`points.json`**: map each `exercises.<Name>Test` to its point value.
   Note CI overwrites this file from the canonical upstream repo before
   grading (see above), so this only drives local practice/feedback, not
   the real grade — keep it consistent with the README table anyway.
5. **`README.md`** structure (see `2-javaoop-template`'s `README.md` for a
   full example):
   - `# <n>-<topic>` title + one-line welcome paragraph.
   - `## What you'll learn` — a short bullet list of the OOP/language
     concepts the topic's exercises cover (e.g. access modifiers,
     constructors, constrained getters/setters, composition, overriding
     `toString`).
   - `## The exercises` — a table: `Exercise | Name | File | Points`.
   - A short paragraph noting the `TODO`, the test files, and `Main.java`.
   - `## Exercise descriptions` — one `### N. Name (Xp)` subsection per
     exercise, description adapted from `assignments_N.txt`, embedding any
     UML image (`![... UML](uml_xxx.png)`).
   - `## Step by step` — instructs students to use **VS Code's Source
     Control view**, not raw `git` commands: clone via **Clone
     Repository**, run tests via the **Testing** icon/Test Explorer, and at
     the end stage changes with **+**, type a commit message, then use the
     arrow next to **Commit** → **Commit & Push** to commit and push in one
     step. Do **not** mention the GitHub Actions autograder/CI check in the
     student-facing README — that's internal grading plumbing, not
     something students need to act on.
6. `Main.java` stays an untouched placeholder in every topic. If one
   exercise's class is used by another (composition, e.g. `Garage` using
   `Vehicle`), implement the dependency first and say so in this file.
