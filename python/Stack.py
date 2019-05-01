'''
检查括号是否完全匹配
有效括号字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。
举例：
((())): True
((()): False
(())): False
'''
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

def balanced_parentheses(parentheses):
    stack = Stack(len(parentheses))
    for parenthese in parentheses:
        if parenthese == '(':
            stack.push(parenthese)
        elif parenthese == ')':
            stack.pop()
    
    if stack.size == 0:
        return True
    else:
        return False

if __name__ == "__main__":
    data = input("please input a string incluing parentheses:")
    if balanced_parentheses(data):
        print("True")
    else:
        print("False")

