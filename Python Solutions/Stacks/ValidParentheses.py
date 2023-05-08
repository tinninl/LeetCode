def isValid(self, s: str) -> bool:
    
    if (len(s) % 2 != 0):
        return False
    
    stack = []

    map = {
        "}" : "{",
        ")" : "(",
        "]" : "["
    }

    for c in s:
    
        if c in map.keys():

            if not stack and stack[-1] == map[c]:
                stack.pop()

            else:
                return False
            
        else:
            stack.append(c)
           
    return not stack
