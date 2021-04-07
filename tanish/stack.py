import sys

//empty stack
stack = []

//push element into stack
stack.append('apple')
stack.append('mango')
stack.append('banana')

print("The initial stack")
print(stack)

print("Now we perform pop operation")
print(stack.pop())
print(stack.pop())
print(stack.pop())

print("\nAfter poping element are:-")
print(stack)