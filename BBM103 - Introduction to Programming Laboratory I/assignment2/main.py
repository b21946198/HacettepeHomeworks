import sys
f=open(sys.argv[1],"r")
commands=[[line.split()] for line in f.readlines()]
f.close()

ct = [["R1", "N1", "B1", "QU", "KI", "B2", "N2", "R2"],                # black
      ["P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8"],
      ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
      ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
      ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
      ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
      ["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"],
      ["r1", "n1", "b1", "qu", "ki", "b2", "n2", "r2"]]               # white

start_board = [["R1", "N1", "B1", "QU", "KI", "B2", "N2", "R2"],
               ["P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8"],
               ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
               ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
               ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
               ["  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "],
               ["p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8"],
               ["r1", "n1", "b1", "qu", "ki", "b2", "n2", "r2"]]

notation = [["a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"],
            ["a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"],
            ["a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"],
            ["a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"],
            ["a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"],
            ["a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"],
            ["a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"],
            ["a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"]]


def pp1():
    for i in ct:
        for j in i:
            if j == "p1":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_p1 = []
                if (ct[yyp1-1][xxp1] == "  " or ct[yyp1-1][xxp1][0].isupper()) and (ct[yyp1-1][xxp1] != "KI"):
                    list_p1.append(notation[yyp1-1][xxp1])
    return list_p1
def pp2():
    for i in ct:
        for j in i:
            if j == "p2":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_p2 = []
                if (ct[yyp1-1][xxp1] == "  " or ct[yyp1-1][xxp1][0].isupper()) and (ct[yyp1-1][xxp1] != "KI"):
                    list_p2.append(notation[yyp1-1][xxp1])
    return list_p2
def pp3():
    for i in ct:
        for j in i:
            if j == "p3":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_p3 = []
                if (ct[yyp1-1][xxp1] == "  " or ct[yyp1-1][xxp1][0].isupper()) and (ct[yyp1-1][xxp1] != "KI"):
                    list_p3.append(notation[yyp1-1][xxp1])
    return list_p3
def pp4():
    for i in ct:
        for j in i:
            if j == "p4":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_p4 = []
                if (ct[yyp1-1][xxp1] == "  " or ct[yyp1-1][xxp1][0].isupper()) and (ct[yyp1-1][xxp1] != "KI"):
                    list_p4.append(notation[yyp1-1][xxp1])
    return list_p4
def pp5():
    for i in ct:
        for j in i:
            if j == "p5":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_p5 = []
                if (ct[yyp1-1][xxp1] == "  " or ct[yyp1-1][xxp1][0].isupper()) and (ct[yyp1-1][xxp1] != "KI"):
                    list_p5.append(notation[yyp1-1][xxp1])
    return list_p5
def pp6():
    for i in ct:
        for j in i:
            if j == "p6":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_p6 = []
                if (ct[yyp1-1][xxp1] == "  " or ct[yyp1-1][xxp1][0].isupper()) and (ct[yyp1-1][xxp1] != "KI"):
                    list_p6.append(notation[yyp1-1][xxp1])
    return list_p6
def pp7():
    for i in ct:
        for j in i:
            if j == "p7":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_p7 = []
                if (ct[yyp1-1][xxp1] == "  " or ct[yyp1-1][xxp1][0].isupper()) and (ct[yyp1-1][xxp1] != "KI"):
                    list_p7.append(notation[yyp1-1][xxp1])
    return list_p7
def pp8():
    for i in ct:
        for j in i:
            if j == "p8":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_p8 = []
                if (ct[yyp1-1][xxp1] == "  " or ct[yyp1-1][xxp1][0].isupper()) and (ct[yyp1-1][xxp1] != "KI"):
                    list_p8.append(notation[yyp1-1][xxp1])
    return list_p8

def PP1():
    for i in ct:
        for j in i:
            if j == "P1":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_P1 = []
                if (ct[yyp1+1][xxp1] == "  " or ct[yyp1+1][xxp1][0].islower()) and (ct[yyp1+1][xxp1] != "ki"):
                    list_P1.append(notation[yyp1+1][xxp1])
    return(list_P1)

def PP2():
    for i in ct:
        for j in i:
            if j == "P2":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_P2 = []
                if (ct[yyp1+1][xxp1] == "  " or ct[yyp1+1][xxp1][0].islower()) and (ct[yyp1+1][xxp1] != "ki"):
                    list_P2.append(notation[yyp1+1][xxp1])
    return list_P2
def PP3():
    for i in ct:
        for j in i:
            if j == "P3":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_P3 = []
                if (ct[yyp1+1][xxp1] == "  " or ct[yyp1+1][xxp1][0].islower()) and (ct[yyp1+1][xxp1] != "ki"):
                    list_P3.append(notation[yyp1+1][xxp1])
    return list_P3
def PP4():
    for i in ct:
        for j in i:
            if j == "P4":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_P4 = []
                if (ct[yyp1+1][xxp1] == "  " or ct[yyp1+1][xxp1][0].islower()) and (ct[yyp1+1][xxp1] != "ki"):
                    list_P4.append(notation[yyp1+1][xxp1])
    return list_P4
def PP5():
    for i in ct:
        for j in i:
            if j == "P5":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_P5 = []
                if (ct[yyp1+1][xxp1] == "  " or ct[yyp1+1][xxp1][0].islower()) and (ct[yyp1+1][xxp1] != "ki"):
                    list_P5.append(notation[yyp1+1][xxp1])
    return list_P5
def PP6():
    for i in ct:
        for j in i:
            if j == "P6":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_P6 = []
                if (ct[yyp1+1][xxp1] == "  " or ct[yyp1+1][xxp1][0].islower()) and (ct[yyp1+1][xxp1] != "ki"):
                    list_P6.append(notation[yyp1+1][xxp1])
    return list_P6
def PP7():
    for i in ct:
        for j in i:
            if j == "P7":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_P7 = []
                if (ct[yyp1+1][xxp1] == "  " or ct[yyp1+1][xxp1][0].islower()) and (ct[yyp1+1][xxp1] != "ki"):
                    list_P7.append(notation[yyp1+1][xxp1])
    return list_P7
def PP8():
    for i in ct:
        for j in i:
            if j == "P8":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_P8 = []
                if (ct[yyp1+1][xxp1] == "  " or ct[yyp1+1][xxp1][0].islower()) and (ct[yyp1+1][xxp1] != "ki"):
                    list_P8.append(notation[yyp1+1][xxp1])
    return list_P8
def nn1():
    for i in ct:
        for j in i:
            if j == "n1":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_n1 = []
                if xxp1 > 0 and yyp1 > 0 :
                    if ct[yyp1-1][xxp1-1] == "  ":
                        list_n1.append(notation[yyp1-1][xxp1-1])
                if xxp1 < 7 and yyp1 > 0 :
                    if ct[yyp1-1][xxp1+1] == "  ":
                        list_n1.append(notation[yyp1-1][xxp1+1])
                if xxp1 < 7 and yyp1 < 7 :
                    if ct[yyp1+1][xxp1+1] == "  ":
                        list_n1.append(notation[yyp1+1][xxp1+1])
                if xxp1 > 0  and yyp1 < 7:
                    if ct[yyp1+1][xxp1-1] == "  ":
                        list_n1.append(notation[yyp1+1][xxp1-1])
                if xxp1 < 7 and yyp1 > 1:
                    if (ct[yyp1-2][xxp1+1] == "  " or ct[yyp1-2][xxp1+1][0].isupper()) and (ct[yyp1-2][xxp1+1] != "KI"):
                        list_n1.append(notation[yyp1-2][xxp1+1])
                if xxp1 > 0 and yyp1 > 1:
                    if (ct[yyp1-2][xxp1-1] == "  " or ct[yyp1-2][xxp1-1][0].isupper()) and (ct[yyp1-2][xxp1-1] != "KI"):
                        list_n1.append(notation[yyp1-2][xxp1-1])
                if xxp1 < 6 and yyp1 > 0:
                    if (ct[yyp1-1][xxp1+2] == "  " or ct[yyp1-1][xxp1+2][0].isupper()) and (ct[yyp1-1][xxp1+2] != "KI"):
                        list_n1.append(notation[yyp1-1][xxp1+2])
                if xxp1 > 1 and yyp1 > 0:
                    if (ct[yyp1-1][xxp1-2] == "  " or ct[yyp1-1][xxp1-2][0].isupper()) and (ct[yyp1-1][xxp1-2] != "KI"):
                        list_n1.append(notation[yyp1-1][xxp1-2])
                if xxp1 < 7 and yyp1 < 6:
                    if (ct[yyp1+2][xxp1+1] == "  " or ct[yyp1+2][xxp1+1][0].isupper()) and (ct[yyp1+2][xxp1+1] != "KI"):
                        list_n1.append(notation[yyp1+2][xxp1+1])
                if xxp1 > 0 and yyp1 < 6:
                    if (ct[yyp1+2][xxp1-1] == "  " or ct[yyp1+2][xxp1-1][0].isupper()) and (ct[yyp1+2][xxp1-1] != "KI"):
                        list_n1.append(notation[yyp1+2][xxp1-1])
                if xxp1 > 1 and yyp1 < 7:
                    if (ct[yyp1+1][xxp1-2] == "  " or ct[yyp1+1][xxp1-2][0].isupper()) and (ct[yyp1+1][xxp1-2] != "KI"):
                        list_n1.append(notation[yyp1+1][xxp1-2])
                if xxp1 < 6 and yyp1 < 7:
                    if (ct[yyp1+1][xxp1+2] == "  " or ct[yyp1+1][xxp1+2][0].isupper()) and (ct[yyp1+1][xxp1+2] != "KI"):
                        list_n1.append(notation[yyp1+1][xxp1+2])
    return sorted(list_n1)


def nn2():
    for i in ct:
        for j in i:
            if j == "n2":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_n2 = []
                if xxp1 > 0 and yyp1 > 0 :
                    if ct[yyp1-1][xxp1-1] == "  ":
                        list_n2.append(notation[yyp1-1][xxp1-1])
                if xxp1 < 7 and yyp1 > 0 :
                    if ct[yyp1-1][xxp1+1] == "  ":
                        list_n2.append(notation[yyp1-1][xxp1+1])
                if xxp1 < 7 and yyp1 < 7 :
                    if ct[yyp1+1][xxp1+1] == "  ":
                        list_n2.append(notation[yyp1+1][xxp1+1])
                if xxp1 > 0  and yyp1 < 7:
                    if ct[yyp1+1][xxp1-1] == "  ":
                        list_n2.append(notation[yyp1+1][xxp1-1])
                if xxp1 < 7 and yyp1 > 1:
                    if (ct[yyp1-2][xxp1+1] == "  " or ct[yyp1-2][xxp1+1][0].isupper()) and (ct[yyp1-2][xxp1+1] != "KI"):
                        list_n2.append(notation[yyp1-2][xxp1+1])
                if xxp1 > 0 and yyp1 > 1:
                    if (ct[yyp1-2][xxp1-1] == "  " or ct[yyp1-2][xxp1-1][0].isupper()) and (ct[yyp1-2][xxp1-1] != "KI"):
                        list_n2.append(notation[yyp1-2][xxp1-1])
                if xxp1 < 6 and yyp1 > 0:
                    if (ct[yyp1-1][xxp1+2] == "  " or ct[yyp1-1][xxp1+2][0].isupper()) and (ct[yyp1-1][xxp1+2] != "KI"):
                        list_n2.append(notation[yyp1-1][xxp1+2])
                if xxp1 > 1 and yyp1 > 0:
                    if (ct[yyp1-1][xxp1-2] == "  " or ct[yyp1-1][xxp1-2][0].isupper()) and (ct[yyp1-1][xxp1-2] != "KI"):
                        list_n2.append(notation[yyp1-1][xxp1-2])
                if xxp1 < 7 and yyp1 < 6:
                    if (ct[yyp1+2][xxp1+1] == "  " or ct[yyp1+2][xxp1+1][0].isupper()) and (ct[yyp1+2][xxp1+1] != "KI"):
                        list_n2.append(notation[yyp1+2][xxp1+1])
                if xxp1 > 0 and yyp1 < 6:
                    if (ct[yyp1+2][xxp1-1] == "  " or ct[yyp1+2][xxp1-1][0].isupper()) and (ct[yyp1+2][xxp1-1] != "KI"):
                        list_n2.append(notation[yyp1+2][xxp1-1])
                if xxp1 > 1 and yyp1 < 7:
                    if (ct[yyp1+1][xxp1-2] == "  " or ct[yyp1+1][xxp1-2][0].isupper()) and (ct[yyp1+1][xxp1-2] != "KI"):
                        list_n2.append(notation[yyp1+1][xxp1-2])
                if xxp1 < 6 and yyp1 < 7:
                    if (ct[yyp1+1][xxp1+2] == "  " or ct[yyp1+1][xxp1+2][0].isupper()) and (ct[yyp1+1][xxp1+2] != "KI"):
                        list_n2.append(notation[yyp1+1][xxp1+2])
    return sorted(list_n2)

def NN1():
    for i in ct:
        for j in i:
            if j == "N1":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_N1 = []
                if xxp1 > 0 and yyp1 > 0 :
                    if ct[yyp1-1][xxp1-1] == "  ":
                        list_N1.append(notation[yyp1-1][xxp1-1])
                if xxp1 < 7 and yyp1 > 0 :
                    if ct[yyp1-1][xxp1+1] == "  ":
                        list_N1.append(notation[yyp1-1][xxp1+1])
                if xxp1 < 7 and yyp1 < 7 :
                    if ct[yyp1+1][xxp1+1] == "  ":
                        list_N1.append(notation[yyp1+1][xxp1+1])
                if xxp1 > 0  and yyp1 < 7:
                    if ct[yyp1+1][xxp1-1] == "  ":
                        list_N1.append(notation[yyp1+1][xxp1-1])
                if xxp1 < 7 and yyp1 > 1:
                    if (ct[yyp1-2][xxp1+1] == "  " or ct[yyp1-2][xxp1+1][0].islower()) and (ct[yyp1-2][xxp1+1] != "ki"):
                        list_N1.append(notation[yyp1-2][xxp1+1])
                if xxp1 > 0 and yyp1 > 1:
                    if (ct[yyp1-2][xxp1-1] == "  " or ct[yyp1-2][xxp1-1][0].islower()) and (ct[yyp1-2][xxp1-1] != "ki"):
                        list_N1.append(notation[yyp1-2][xxp1-1])
                if xxp1 < 6 and yyp1 > 0:
                    if (ct[yyp1-1][xxp1+2] == "  " or ct[yyp1-1][xxp1+2][0].islower()) and (ct[yyp1-1][xxp1+2] != "ki"):
                        list_N1.append(notation[yyp1-1][xxp1+2])
                if xxp1 > 1 and yyp1 > 0:
                    if (ct[yyp1-1][xxp1-2] == "  " or ct[yyp1-1][xxp1-2][0].islower()) and (ct[yyp1-1][xxp1-2] != "ki"):
                        list_N1.append(notation[yyp1-1][xxp1-2])
                if xxp1 < 7 and yyp1 < 6:
                    if (ct[yyp1+2][xxp1+1] == "  " or ct[yyp1+2][xxp1+1][0].islower()) and (ct[yyp1+2][xxp1+1] != "ki"):
                        list_N1.append(notation[yyp1+2][xxp1+1])
                if xxp1 > 0 and yyp1 < 6:
                    if (ct[yyp1+2][xxp1-1] == "  " or ct[yyp1+2][xxp1-1][0].islower()) and (ct[yyp1+2][xxp1-1] != "ki"):
                        list_N1.append(notation[yyp1+2][xxp1-1])
                if xxp1 > 1 and yyp1 < 7:
                    if (ct[yyp1+1][xxp1-2] == "  " or ct[yyp1+1][xxp1-2][0].islower()) and (ct[yyp1+1][xxp1-2] != "ki"):
                        list_N1.append(notation[yyp1+1][xxp1-2])
                if xxp1 < 6 and yyp1 < 7:
                    if (ct[yyp1+1][xxp1+2] == "  " or ct[yyp1+1][xxp1+2][0].islower()) and (ct[yyp1+1][xxp1+2] != "ki"):
                        list_N1.append(notation[yyp1+1][xxp1+2])
    return sorted(list_N1)


def NN2():
    for i in ct:
        for j in i:
            if j == "N2":
                xxp1 = i.index(j)
                yyp1 = ct.index(i)
                list_N2 = []
                if xxp1 > 0 and yyp1 > 0 :
                    if ct[yyp1-1][xxp1-1] == "  ":
                        list_N2.append(notation[yyp1-1][xxp1-1])
                if xxp1 < 7 and yyp1 > 0 :
                    if ct[yyp1-1][xxp1+1] == "  ":
                        list_N2.append(notation[yyp1-1][xxp1+1])
                if xxp1 < 7 and yyp1 < 7 :
                    if ct[yyp1+1][xxp1+1] == "  ":
                        list_N2.append(notation[yyp1+1][xxp1+1])
                if xxp1 > 0  and yyp1 < 7:
                    if ct[yyp1+1][xxp1-1] == "  ":
                        list_N2.append(notation[yyp1+1][xxp1-1])
                if xxp1 < 7 and yyp1 > 1:
                    if (ct[yyp1-2][xxp1+1] == "  " or ct[yyp1-2][xxp1+1][0].islower()) and (ct[yyp1-2][xxp1+1] != "ki"):
                        list_N2.append(notation[yyp1-2][xxp1+1])
                if xxp1 > 0 and yyp1 > 1:
                    if (ct[yyp1-2][xxp1-1] == "  " or ct[yyp1-2][xxp1-1][0].islower()) and (ct[yyp1-2][xxp1-1] != "ki"):
                        list_N2.append(notation[yyp1-2][xxp1-1])
                if xxp1 < 6 and yyp1 > 0:
                    if (ct[yyp1-1][xxp1+2] == "  " or ct[yyp1-1][xxp1+2][0].islower()) and (ct[yyp1-1][xxp1+2] != "ki"):
                        list_N2.append(notation[yyp1-1][xxp1+2])
                if xxp1 > 1 and yyp1 > 0:
                    if (ct[yyp1-1][xxp1-2] == "  " or ct[yyp1-1][xxp1-2][0].islower()) and (ct[yyp1-1][xxp1-2] != "ki"):
                        list_N2.append(notation[yyp1-1][xxp1-2])
                if xxp1 < 7 and yyp1 < 6:
                    if (ct[yyp1+2][xxp1+1] == "  " or ct[yyp1+2][xxp1+1][0].islower()) and (ct[yyp1+2][xxp1+1] != "ki"):
                        list_N2.append(notation[yyp1+2][xxp1+1])
                if xxp1 > 0 and yyp1 < 6:
                    if (ct[yyp1+2][xxp1-1] == "  " or ct[yyp1+2][xxp1-1][0].islower()) and (ct[yyp1+2][xxp1-1] != "ki"):
                        list_N2.append(notation[yyp1+2][xxp1-1])
                if xxp1 > 1 and yyp1 < 7:
                    if (ct[yyp1+1][xxp1-2] == "  " or ct[yyp1+1][xxp1-2][0].islower()) and (ct[yyp1+1][xxp1-2] != "ki"):
                        list_N2.append(notation[yyp1+1][xxp1-2])
                if xxp1 < 6 and yyp1 < 7:
                    if (ct[yyp1+1][xxp1+2] == "  " or ct[yyp1+1][xxp1+2][0].islower()) and (ct[yyp1+1][xxp1+2] != "ki"):
                        list_N2.append(notation[yyp1+1][xxp1+2])
    return sorted(list_N2)

def bb1():
    for i in ct:
        for j in i:
            if j == "b1":
                xx = i.index(j)
                yy = ct.index(i)
                list_b1 = []
                while yy > 0 and xx < 7:
                    yy -= 1
                    xx += 1
                    if ct[yy][xx] == "  ":
                        list_b1.append(notation[yy][xx])
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_b1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx][0].islower():
                        break

    for i in ct:
        for j in i:
            if j == "b1":
                xx = i.index(j)
                yy = ct.index(i)
                while yy > 0 and xx > 0:
                    yy -= 1
                    xx -= 1
                    if ct[yy][xx] == "  ":
                        list_b1.append(notation[yy][xx])
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_b1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx][0].islower():
                        break
    return sorted(list_b1)


def bb2():
    for i in ct:
        for j in i:
            if j == "b2":
                xx = i.index(j)
                yy = ct.index(i)
                list_b2 = []
                while yy > 0 and xx < 7:
                    yy -= 1
                    xx += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_b2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_b2.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "b2":
                xx = i.index(j)
                yy = ct.index(i)
                while yy > 0 and xx > 0:
                    yy -= 1
                    xx -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_b2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_b2.append(notation[yy][xx])
    return sorted(list_b2)


def BB1():
    for i in ct:
        for j in i:
            if j == "B1":
                xx = i.index(j)
                yy = ct.index(i)
                list_B1 = []
                while yy < 7 and xx < 7:
                    yy += 1
                    xx += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_B1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_B1.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "B1":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7 and xx > 0:
                    yy += 1
                    xx -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_B1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_B1.append(notation[yy][xx])
    return sorted(list_B1)


def BB2():
    for i in ct:
        for j in i:
            if j == "B2":
                xx = i.index(j)
                yy = ct.index(i)
                list_B2 = []
                while yy < 7 and xx < 7:
                    yy += 1
                    xx += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_B2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_B2.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "B2":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7 and xx > 0:
                    yy += 1
                    xx -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower and ct[yy][xx] != "ki":
                        list_B2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_B2.append(notation[yy][xx])
    return sorted(list_B2)

def rr1():
    for i in ct:
        for j in i:
            if j == "r1":
                xx = i.index(j)
                yy = ct.index(i)
                list_r1 = []
                while yy > 0:
                    yy -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_r1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_r1.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "r1":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7:
                    yy += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_r1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_r1.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "r1":
                xx = i.index(j)
                yy = ct.index(i)
                while xx < 7:
                    xx += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_r1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_r1.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "r1":
                xx = i.index(j)
                yy = ct.index(i)
                while xx > 0:
                    xx -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_r1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_r1.append(notation[yy][xx])
    return sorted(list_r1)

def rr2():
    for i in ct:
        for j in i:
            if j == "r2":
                xx = i.index(j)
                yy = ct.index(i)
                list_r2 = []
                while yy > 0:
                    yy -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_r2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_r2.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "r2":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7:
                    yy += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_r2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_r2.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "r2":
                xx = i.index(j)
                yy = ct.index(i)
                while xx < 7:
                    xx += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_r2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_r2.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "r2":
                xx = i.index(j)
                yy = ct.index(i)
                while xx > 0:
                    xx -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_r2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_r2.append(notation[yy][xx])
    return sorted(list_r2)

def RR1():
    for i in ct:
        for j in i:
            if j == "R1":
                xx = i.index(j)
                yy = ct.index(i)
                list_R1 = []
                while yy > 0:
                    yy -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_R1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_R1.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "R1":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7:
                    yy += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_R1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_R1.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "R1":
                xx = i.index(j)
                yy = ct.index(i)
                while xx < 7:
                    xx += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_R1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_R1.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "R1":
                xx = i.index(j)
                yy = ct.index(i)
                while xx > 0:
                    xx -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_R1.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_R1.append(notation[yy][xx])
    return sorted(list_R1)

def RR2():
    for i in ct:
        for j in i:
            if j == "R2":
                xx = i.index(j)
                yy = ct.index(i)
                list_R2 = []
                while yy > 0:
                    yy -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_R2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_R2.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "R2":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7:
                    yy += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_R2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_R2.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "R2":
                xx = i.index(j)
                yy = ct.index(i)
                while xx < 7:
                    xx += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_R2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_R2.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "R2":
                xx = i.index(j)
                yy = ct.index(i)
                while xx > 0:
                    xx -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_R2.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_R2.append(notation[yy][xx])
    return sorted(list_R2)


def qqu():
    for i in ct:
        for j in i:
            if j == "qu":
                xx = i.index(j)
                yy = ct.index(i)
                list_qu = []
                while yy > 0 and xx < 7:
                    yy -= 1
                    xx += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_qu.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_qu.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "qu":
                xx = i.index(j)
                yy = ct.index(i)
                while yy > 0 and xx > 0:
                    yy -= 1
                    xx -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_qu.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_qu.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "qu":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7 and xx < 7:
                    yy += 1
                    xx += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_qu.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_qu.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "qu":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7 and xx > 0:
                    yy += 1
                    xx -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_qu.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_qu.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "qu":
                xx = i.index(j)
                yy = ct.index(i)
                while yy > 0:
                    yy -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_qu.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_qu.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "qu":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7:
                    yy += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_qu.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_qu.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "qu":
                xx = i.index(j)
                yy = ct.index(i)
                while xx < 7:
                    xx += 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_qu.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_qu.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "qu":
                xx = i.index(j)
                yy = ct.index(i)
                while xx > 0:
                    xx -= 1
                    if ct[yy][xx][0].islower():
                        break
                    elif ct[yy][xx][0].isupper() and ct[yy][xx] != "KI":
                        list_qu.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_qu.append(notation[yy][xx])
    return sorted(list_qu)

def QQU():
    for i in ct:
        for j in i:
            if j == "QU":
                xx = i.index(j)
                yy = ct.index(i)
                list_QU = []
                while yy > 0 and xx < 7:
                    yy -= 1
                    xx += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_QU.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_QU.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "QU":
                xx = i.index(j)
                yy = ct.index(i)
                while yy > 0 and xx > 0:
                    yy -= 1
                    xx -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_QU.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_QU.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "QU":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7 and xx < 7:
                    yy += 1
                    xx += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_QU.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_QU.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "QU":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7 and xx > 0:
                    yy += 1
                    xx -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_QU.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_QU.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "QU":
                xx = i.index(j)
                yy = ct.index(i)
                while yy > 0:
                    yy -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_QU.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_QU.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "QU":
                xx = i.index(j)
                yy = ct.index(i)
                while yy < 7:
                    yy += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_QU.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_QU.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "QU":
                xx = i.index(j)
                yy = ct.index(i)
                while xx < 7:
                    xx += 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_QU.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_QU.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "QU":
                xx = i.index(j)
                yy = ct.index(i)
                while xx > 0:
                    xx -= 1
                    if ct[yy][xx][0].isupper():
                        break
                    elif ct[yy][xx][0].islower() and ct[yy][xx] != "ki":
                        list_QU.append(notation[yy][xx])
                        break
                    elif ct[yy][xx] == "  ":
                        list_QU.append(notation[yy][xx])
    return sorted(list_QU)


def kki():
    for i in ct:
        for j in i:
            if j == "ki":
                xx = i.index(j)
                yy = ct.index(i)
                list_ki = []
                if yy > 0 and xx > 0:
                    xx -= 1
                    yy -= 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].isupper()) and (ct[yy][xx] != "KI"):
                        list_ki.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "ki":
                xx = i.index(j)
                yy = ct.index(i)
                if yy > 0 :
                    yy -= 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].isupper()) and (ct[yy][xx] != "KI"):
                        list_ki.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "ki":
                xx = i.index(j)
                yy = ct.index(i)
                if yy > 0 and xx < 7:
                    xx += 1
                    yy -= 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].isupper()) and (ct[yy][xx] != "KI"):
                        list_ki.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "ki":
                xx = i.index(j)
                yy = ct.index(i)
                if xx > 0:
                    xx -= 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].isupper()) and (ct[yy][xx] != "KI"):
                        list_ki.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "ki":
                xx = i.index(j)
                yy = ct.index(i)
                if xx < 7:
                    xx += 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].isupper()) and (ct[yy][xx] != "KI"):
                        list_ki.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "ki":
                xx = i.index(j)
                yy = ct.index(i)
                if yy < 7 and xx > 0:
                    xx -= 1
                    yy += 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].isupper()) and (ct[yy][xx] != "KI"):
                        list_ki.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "ki":
                xx = i.index(j)
                yy = ct.index(i)
                if yy < 7 :
                    yy += 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].isupper()) and (ct[yy][xx] != "KI"):
                        list_ki.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "ki":
                xx = i.index(j)
                yy = ct.index(i)
                if yy < 7 and xx < 7:
                    xx += 1
                    yy += 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].isupper()) and (ct[yy][xx] != "KI"):
                        list_ki.append(notation[yy][xx])
    return sorted(list_ki)


def KKI():
    for i in ct:
        for j in i:
            if j == "KI":
                xx = i.index(j)
                yy = ct.index(i)
                list_KI = []
                if yy > 0 and xx > 0:
                    xx -= 1
                    yy -= 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].islower()) and (ct[yy][xx] != "ki"):
                        list_KI.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "KI":
                xx = i.index(j)
                yy = ct.index(i)
                if yy > 0 :
                    yy -= 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].islower()) and (ct[yy][xx] != "ki"):
                        list_KI.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "KI":
                xx = i.index(j)
                yy = ct.index(i)
                if yy > 0 and xx < 7:
                    xx += 1
                    yy -= 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].islower()) and (ct[yy][xx] != "ki"):
                        list_KI.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "KI":
                xx = i.index(j)
                yy = ct.index(i)
                if xx > 0:
                    xx -= 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].islower()) and (ct[yy][xx] != "ki"):
                        list_KI.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "KI":
                xx = i.index(j)
                yy = ct.index(i)
                if xx < 7:
                    xx += 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].islower()) and (ct[yy][xx] != "ki"):
                        list_KI.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "KI":
                xx = i.index(j)
                yy = ct.index(i)
                if yy < 7 and xx > 0:
                    xx -= 1
                    yy += 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].islower()) and (ct[yy][xx] != "ki"):
                        list_KI.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "KI":
                xx = i.index(j)
                yy = ct.index(i)
                if yy < 7 :
                    yy += 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].islower()) and (ct[yy][xx] != "ki"):
                        list_KI.append(notation[yy][xx])

    for i in ct:
        for j in i:
            if j == "KI":
                xx = i.index(j)
                yy = ct.index(i)
                if yy < 7 and xx < 7:
                    xx += 1
                    yy += 1
                    if (ct[yy][xx] == "  " or ct[yy][xx].islower()) and (ct[yy][xx] != "ki"):
                        list_KI.append(notation[yy][xx])
    return sorted(list_KI)

for c in commands:
    for k in c:
        if k[0] == "move":
            if k[1] == "p1":
                print(">", *k, sep=" ")
                if k[2] in pp1():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "p1":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "p1"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "p2":
                print(">", *k, sep=" ")
                if k[2] in pp2():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "p2":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "p2"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "p3":
                print(">", *k, sep=" ")
                if k[2] in pp3():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "p3":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "p3"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")



            elif k[1] == "p4":
                print(">", *k, sep=" ")
                if k[2] in pp4():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "p4":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "p4"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")



            elif k[1] == "p5":
                print(">", *k, sep=" ")
                if k[2] in pp5():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "p5":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "p5"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "p6":
                print(">", *k, sep=" ")
                if k[2] in pp6():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "p6":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "p6"
                                            ct[yy2][xx2] = "  "

                else:
                    print("FAILED")


            elif k[1] == "p7":
                print(">", *k, sep=" ")
                if k[2] in pp7():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "p7":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "p7"
                                            ct[yy2][xx2] = "  "

                else:
                    print("FAILED")


            elif k[1] == "p8":
                print(">", *k, sep=" ")
                if k[2] in pp8():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "p8":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "p8"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "n1":
                print(">", *k, sep=" ")
                if k[2] in nn1():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "n1":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "n1"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "n2":
                print(">", *k, sep=" ")
                if k[2] in nn2():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "n2":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "n2"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "b1":
                print(">", *k, sep=" ")
                if k[2] in bb1():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "b1":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "b1"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")



            elif k[1] == "b2":
                print(">", *k, sep=" ")
                if k[2] in bb2():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "b2":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "b2"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "r1":
                print(">", *k, sep=" ")
                if k[2] in rr1():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "r1":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "r1"
                                            ct[yy2][xx2] = "  "
                else:
                    print("FAILED")


            elif k[1] == "r2":
                print(">", *k, sep=" ")
                if k[2] in rr2():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "rr2":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "r2"
                                            ct[yy2][xx2] = "  "
                else:
                    print("FAILED")



            elif k[1] == "qu":
                print(">", *k, sep=" ")
                if k[2] in qqu():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "qu":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "qu"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "ki":
                print(">", *k, sep=" ")
                if k[2] in kki():
                    print("OK")
                    for o in ct:
                        for p in o:
                            if p == "ki":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "ki"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")



            elif k[1] == "P1":
                print(">", *k, sep=" ")
                if k[2] in PP1():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "P1":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "P1"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")

            elif k[1] == "P2":
                print(">", *k, sep=" ")
                if k[2] in PP2():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "P2":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "P2"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "P3":
                print(">", *k, sep=" ")
                if k[2] in PP3():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "P3":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "P3"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "P4":
                print(">", *k, sep=" ")
                if k[2] in PP4():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "P4":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "P4"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "P5":
                print(">", *k, sep=" ")
                if k[2] in PP5():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "P5":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "P5"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "P6":
                print(">", *k, sep=" ")
                if k[2] in PP6():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "P6":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "P6"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "P7":
                print(">", *k, sep=" ")
                if k[2] in PP7():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "P7":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "P7"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "P8":
                print(">", *k, sep=" ")
                if k[2] in PP8():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "P8":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "P8"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "N1":
                print(">", *k, sep=" ")
                if k[2] in NN1():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "N1":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "N1"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "N2":
                print(">", *k, sep=" ")
                if k[2] in NN2():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "N2":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "N2"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "B1":
                print(">", *k, sep=" ")
                if k[2] in BB1():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "B1":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "B1"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "B2":
                print(">", *k, sep=" ")
                if k[2] in BB2():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "B2":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "B2"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "R1":
                print(">", *k, sep=" ")
                if k[2] in RR1():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "R1":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "R1"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "RR2":
                print(">", *k, sep=" ")
                if k[2] in RR2():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "R":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "R2"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")



            elif k[1] == "QU":
                print(">", *k, sep=" ")
                if k[2] in QQU():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "QU":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "QU"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")


            elif k[1] == "KI":
                print(">", *k, sep=" ")
                if k[2] in KKI():
                    print("OK")
                    for o in reversed(ct):
                        for p in reversed(o):
                            if p == "KI":
                                xx2 = o.index(p)
                                yy2 = ct.index(o)
                                for q in notation:
                                    for w in q:
                                        if w == k[2]:
                                            xx3 = q.index(w)
                                            yy3 = notation.index(q)
                                            ct[yy3][xx3] = "KI"
                                            ct[yy2][xx2] = "  "


                else:
                    print("FAILED")




        elif k[0] == "showmoves":
            if k[1] == "p1":
                print(">", *k, sep=" ")
                if pp1() == []:
                    print("FAILED")
                else:
                    for i in pp1():
                        print(i)

            elif k[1] == "p2":
                print(">", *k, sep=" ")
                if pp2() == []:
                    print("FAILED")
                else:
                    for i in pp2():
                        print(i)

            elif k[1] == "p3":
                print(">", *k, sep=" ")
                if pp3() == []:
                    print("FAILED")
                else:
                    for i in pp3():
                        print(i)

            elif k[1] == "p4":
                print(">", *k, sep=" ")
                if pp4() == []:
                    print("FAILED")
                else:
                    for i in pp4():
                        print(i)

            elif k[1] == "p5":
                print(">", *k, sep=" ")
                if pp5() == []:
                    print("FAILED")
                else:
                    for i in pp5():
                        print(i)


            elif k[1] == "p6":
                print(">", *k, sep=" ")
                if pp6() == []:
                    print("FAILED")
                else:
                    for i in pp6():
                        print(i)

            elif k[1] == "p7":
                print(">", *k, sep=" ")
                if pp7() == []:
                    print("FAILED")
                else:
                    for i in pp7():
                        print(i)

            elif k[1] == "p8":
                print(">", *k, sep=" ")
                if pp8() == []:
                    print("FAILED")
                else:
                    for i in pp8():
                        print(i)

            elif k[1] == "P1":
                print(">", *k, sep=" ")
                if PP1() == []:
                    print("FAILED")
                else:
                    for i in PP1():
                        print(i)

            elif k[1] == "P2":
                print(">", *k, sep=" ")
                if PP2() == []:
                    print("FAILED")
                else:
                    for i in PP2():
                        print(i)

            elif k[1] == "P3":
                print(">", *k, sep=" ")
                if PP3() == []:
                    print("FAILED")
                else:
                    for i in PP3():
                        print(i)

            elif k[1] == "P4":
                print(">", *k, sep=" ")
                if PP4() == []:
                    print("FAILED")
                else:
                    for i in PP4():
                        print(i)

            elif k[1] == "P5":
                print(">", *k, sep=" ")
                if PP5() == []:
                    print("FAILED")
                else:
                    for i in PP5():
                        print(i)


            elif k[1] == "P6":
                print(">", *k, sep=" ")
                if PP6() == []:
                    print("FAILED")
                else:
                    for i in PP6():
                        print(i)

            elif k[1] == "P7":
                print(">", *k, sep=" ")
                if PP7() == []:
                    print("FAILED")
                else:
                    for i in PP7():
                        print(i)

            elif k[1] == "P8":
                print(">", *k, sep=" ")
                if PP8() == []:
                    print("FAILED")
                else:
                    for i in PP8():
                        print(i)

            elif k[1] == "n1":
                print(">", *k, sep=" ")
                if nn1() == []:
                    print("FAILED")
                else:
                    print(" ".join(nn1()))

            elif k[1] == "n2":
                print(">", *k, sep=" ")
                if nn2() == []:
                    print("FAILED")
                else:
                    print(" ".join(nn2()))

            elif k[1] == "N1":
                print(">", *k, sep=" ")
                if NN1() == []:
                    print("FAILED")
                else:
                    print(" ".join(NN1()))

            elif k[1] == "N2":
                print(">", *k, sep=" ")
                if NN2() == []:
                    print("FAILED")
                else:
                    print(" ".join(NN2()))

            elif k[1] == "b1":
                print(">", *k, sep=" ")
                if bb1() == []:
                    print("FAILED")
                else:
                    print(" ".join(bb1()))

            elif k[1] == "b2":
                print(">", *k, sep=" ")
                if bb2() == []:
                    print("FAILED")
                else:
                    print(" ".join(bb2()))

            elif k[1] == "B1":
                print(">", *k, sep=" ")
                if BB1() == []:
                    print("FAILED")
                else:
                    print(" ".join(BB1()))

            elif k[1] == "B2":
                print(">", *k, sep=" ")
                if BB2() == []:
                    print("FAILED")
                else:
                    print(" ".join(BB2()))

            elif k[1] == "r1":
                print(">", *k, sep=" ")
                if rr1() == []:
                    print("FAILED")
                else:
                    print(" ".join(rr1()))

            elif k[1] == "r2":
                print(">", *k, sep=" ")
                if rr2() == []:
                    print("FAILED")
                else:
                    print(" ".join(rr2()))

            elif k[1] == "R1":
                print(">", *k, sep=" ")
                if RR1() == []:
                    print("FAILED")
                else:
                    print(" ".join(RR1()))

            elif k[1] == "R2":
                print(">", *k, sep=" ")
                if RR2() == []:
                    print("FAILED")
                else:
                    print(" ".join(RR2()))

            elif k[1] == "qu":
                print(">", *k, sep=" ")
                if qqu() == []:
                    print("FAILED")
                else:
                    print(" ".join(qqu()))

            elif k[1] == "QU":
                print(">", *k, sep=" ")
                if QQU() == []:
                    print("FAILED")
                else:
                    print(" ".join(QQU()))

            elif k[1] == "ki":
                print(">", *k, sep=" ")
                if kki() == []:
                    print("FAILED")
                else:
                    print(" ".join(kki()))

            elif k[1] == "KI":
                print(">", *k, sep=" ")
                if KKI() == []:
                    print("FAILED")
                else:
                    print(" ".join(KKI()))


        elif k[0] == "print":
            print(">","print")
            print("-------------------------")
            for a in ct:
                print(*a, sep=" ")
            print("-------------------------")

        elif k[0] == "initialize":
            ct = start_board
            print(">","initialize")
            print("OK")
            print("-------------------------")
            for a in ct:
                print(*a, sep=" ")
            print("-------------------------")

        elif k[0] == "exit":
            print(">","exit")
            exit()