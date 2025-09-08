# Part 2: Low-Level Code Analysis

Analyze and refactor the given Java code

## Explain what the transform method is doing
The transform method is calculating sum of the squares of all digits.
For example: 12 is transformed to 5 by (1^2 + 2^2)

## Identify any potential issues or inefficiencies
Issues:
- If array contains negative number, the transformed value is always 0

Inefficiencies:
- At line: result += (input % 10) * (input % 10); => leverage built-in Math function instead of computing twice 

Others:
- Should use a descriptive function name like sumOfDigitSquares
- Integer array should be passed through input instead of hard-coding in real-world case
