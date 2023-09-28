import ast

x = input("Please enter feeding map as a list: ")

list_map = ast.literal_eval(x)

""""['W', 'X', 'W', 'C', 'X']
    ['A', 'W', 'W', 'A', 'X']
    ['C', 'X', 'X', 'W', 'P']            map bu    
    ['X', 'X', 'X', 'X', 'X']
    ['X', '*', 'X', 'X', 'X']"""

y = input("Please enter direction of movements as a list: ")
list_directions = ast.literal_eval(y)
# ['L', 'L', 'U', 'L']                directions bu
print("Your board is:")
for umut in list_map:
    print(*umut, sep = " ")


width = len(list_map[0])      #
height = len(list_map)        #
score = 0

for i in list_map:
    for j in i:
        if j == "*":  # j is rabbit
            xx = i.index(j)
            yy = list_map.index(i)

for move in list_directions:
    if move == "L":
        xx -= 1
        if xx < 0:
            xx = 0
            continue
        elif list_map[yy][xx] == "P":
            list_map[yy][xx + 1] = "X"
            list_map[yy][xx] = "*"
            break
        elif list_map[yy][xx] == "W":
            xx += 1
            continue
        elif xx >= 0:
            if list_map[yy][xx] == "C":
                score += 10
            elif list_map[yy][xx] == "A":
                score += 5
            elif list_map[yy][xx] == "M":
                score -= 5
            list_map[yy][xx + 1] = "X"
            list_map[yy][xx] = "*"

    elif move == "R":
        xx += 1
        if xx >= width:
            xx = width - 1
            continue
        elif list_map[yy][xx] == "P":
            list_map[yy][xx - 1] = "X"
            list_map[yy][xx] = "*"
            break
        elif list_map[yy][xx] == "W":
            xx -= 1
            continue
        elif xx < width:
            if list_map[yy][xx] == "C":
                score += 10
            elif list_map[yy][xx] == "A":
                score += 5
            elif list_map[yy][xx] == "M":
                score -= 5
            list_map[yy][xx - 1] = "X"
            list_map[yy][xx] = "*"


    elif move == "U":
        yy -= 1
        if yy < 0:
            yy = 0
            continue
        elif list_map[yy][xx] == "P":
            list_map[yy + 1][xx] = "X"
            list_map[yy][xx] = "*"
            break
        elif list_map[yy][xx] == "W":
            yy += 1
            continue
        elif yy >= 0:
            if list_map[yy][xx] == "C":
                score += 10
            elif list_map[yy][xx] == "A":
                score += 5
            elif list_map[yy][xx] == "M":
                score -= 5
            list_map[yy + 1][xx] = "X"
            list_map[yy][xx] = "*"

    elif move == "D":
        yy += 1
        if yy >= height:
            yy = height - 1
            continue
        elif list_map[yy][xx] == "P":
            list_map[yy - 1][xx] = "X"
            list_map[yy][xx] = "*"
            break
        elif list_map[yy][xx] == "W":
            yy -= 1
            continue
        elif yy < height:
            if list_map[yy][xx] == "C":
                score += 10
            elif list_map[yy][xx] == "A":
                score += 5
            elif list_map[yy][xx] == "M":
                score -= 5
            list_map[yy - 1][xx] = "X"
            list_map[yy][xx] = "*"




print("You output should be like tihs:")
for umut in list_map:
    print(*umut, sep = " ")

print("Your score is:",score)



























