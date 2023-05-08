def searchMatrix(self, matrix: list[list[int]], target: int) -> bool:
    
    row = len(matrix) - 1
    col = 0
    
    while (row >= 0) and (col < len(matrix[0])):
        
        num = matrix[row][col]
        
        if (num < target):
            col += 1
            
        elif (num > target):
            row -= 1
            
        else:
            return True
        
    return False

"""
Not much diff from java code
"""