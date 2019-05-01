'''
No.1:
    检查括号是否完全匹配
    有效括号字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。
    举例：
    ((())): True
    ((()): False
    (())): False
No.2:

'''
import argparse

class Stack(object):
    def __init__(self,limit=10):
        self.stack = []
        self.limit = limit 
    
    def push(self,data):
        if len(self.stack) > self.limit:
            print("StackOverflowError!")

        else:
            self.stack.append(data)

    def pop(self):
        if self.stack:
            self.stack.pop()
        else:
            print("NoneItemInStack!")
    
    def peek(self):
        if self.stack:
            return self.stack[-1]
        else:
            print("NoneItemInStack!")

    def size(self):
        return len(self.stack)


def parse_args():
    ##解析输入的命令
    parser = argparse.ArgumentParser(description="Test Stack Application")
    parser.add_argument('--fun', nargs='?', default='count_Postifix_expression',
	                    help="count a Postifix-expression's result")

    return parser.parse_args()

def balanced_parentheses(parentheses):
    stack = Stack(len(parentheses))
    for parenthese in parentheses:
        if parenthese == '(':
            stack.push(parenthese)
        elif parenthese == ')':
            stack.pop()
    
    if stack.size == 0:
        print('True')
    else:
        print('False')

def count(a,b,op):
    if op == '+':
        return a+b
    elif op == '-':
        return a-b
    elif op == '*':
        return a*b
    else:
        return a/b   

def count_postifix_expression(expression):
    operator = ["+","-","*","/"]

    expression = expression.strip().split()
    stack = Stack(len(expression))
    for item in expression:
        if item not in operator:
            stack.push(item)
        else:
            a = int(stack.pop())
            b = int(stack.pop())
            res = count(a,b,item)
            stack.push(res)
    print(stack.peek())   

def main(args):
    if args.fun == 'balanced_parentheses':
        parentheses = input()
        balanced_parentheses(parentheses)
    
    if args.fun == 'count_postifix_expression':
        expression = input()
        count_postifix_expression(expression)

if __name__ == "__main__":
    args = parse_args()
    main(args)
