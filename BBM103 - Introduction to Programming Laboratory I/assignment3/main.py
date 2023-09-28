import sys
if len(sys.argv) == 5:
    try:
        dict = {"A": 1, "B": 2, "C": 3, "D": 4, "E": 5, "F": 6, "G": 7, "H": 8, "I": 9, "J": 10, "K":11, "L": 12,
                "M": 13, "N": 14, "O": 15, "P": 16, "Q": 17, "R": 18, "S": 19, "T": 20, "U": 21, "V": 22, "W": 23,
                "X": 24, "Y": 25, "Z": 26, "a": 1, "b": 2, "c": 3, "d": 4, "e": 5, "f": 6, "g": 7, "h": 8, "i": 9,
                "j": 10, "k": 11, "l": 12, "m": 13, "n": 14, "o": 15, "p": 16, "q": 17, "r": 18, "s": 19, "t": 20,
                "u": 21, "v": 22, "w": 23, "x": 24, "y": 25, "z": 26, " ": 27}
        dict2 = {1: "A", 2: "B", 3: "C", 4: "D", 5: "E", 6: "F", 7: "G", 8: "H", 9: "I", 10: "J", 11: "K", 12: "L",
                 13: "M", 14: "N", 15: "O", 16: "P", 17: "Q", 18: "R", 19: "S", 20: "T", 21: "U", 22: "V", 23: "W",
                 24: "X", 25: "Y", 26: "Z", 27: " "}
        if sys.argv[1] == "enc":
            if "txt" not in sys.argv[2]:
                print("Key file could not be read")
            with open(sys.argv[2]) as f:
                key_matrix = [i.strip().split(",") for i in f.readlines()]

            for n in key_matrix:
                for i in range(0, len(n)):
                    n[i] = int(n[i])

            if "txt" not in sys.argv[3]:
                print("The input file could not be read error")
            with open(sys.argv[3]) as file:
                matrix = file.read()
            if len(matrix) > 0:

                if len(key_matrix) == 2:
                    if len(matrix) % len(key_matrix) == 1:
                        matrix = matrix + " "

                else:
                    if len(matrix) % len(key_matrix) == 1:
                        matrix = matrix + " "
                    elif len(matrix) % len(key_matrix) == 2:
                        matrix = matrix + " " + " "
            else:
                print("Input file is empty error")
            list_matrix = []
            for i in range(0, len(matrix)):
                list_matrix.append(dict[matrix[i]])


            matrixed = [list_matrix[x:x+len(key_matrix)] for x in range(0, len(list_matrix), len(key_matrix))]
            matrix_b = [[j] for i in matrixed for j in i]
            matrix_a = [matrix_b[y:y+len(key_matrix)] for y in range(0, len(matrix_b), len(key_matrix))]
            encrypted_list = []
            result = [[0] for i in range(len(key_matrix))]
            for matrix2 in matrix_a:
                for i in range(len(key_matrix)):
                    for j in range(len(matrix2[0])):
                        for k in range(len(matrix2)):
                            result[i][j] += key_matrix[i][k] * matrix2[k][j]
                encrypted_list.append(result)
                result = [[0] for abc in range(len(key_matrix))]

            last = []
            for i in encrypted_list:
                for j in i:
                    for k in j:
                        last.append(k)

            son_file = open(sys.argv[4], "w")
            st56 = ""
            for ele in last:
                st56 += str(ele) + ","
            st56 = st56[:-1]
            son_file.write(st56)
            son_file.close()

        elif sys.argv[1] == "dec":
            if "txt" not in sys.argv[2]:
                print("Key file could not be read")
            with open(sys.argv[2]) as fin:
                deter = [i.strip().split(",") for i in fin.readlines()]
            for n in deter:
                for i in range(0, len(n)):
                    n[i] = int(n[i])

            if len(deter) == 2:
                a = deter[0][0]
                b = deter[0][1]
                c = deter[1][0]
                d = deter[1][1]
                deter[0][0] = d
                deter[0][1] = b * (-1)
                deter[1][0] = c * (-1)
                deter[1][1] = a

                xy = 1 / (a*d - b*c)
                for ab in deter:
                    for ba in range(len(ab)):
                        ab[ba] *= xy

            else:
                a = deter[0][0]
                b = deter[0][1]
                c = deter[0][2]
                d = deter[1][0]
                e = deter[1][1]
                f = deter[1][2]
                g = deter[2][0]
                h = deter[2][1]
                i = deter[2][2]

                deter[0][0] = (e*i) - (h*f)
                deter[0][1] = (h*c) - (b*i)
                deter[0][2] = (b*f) - (e*c)
                deter[1][0] = (g*f) - (d*i)
                deter[1][1] = (a*i) - (g*c)
                deter[1][2] = (d*c) - (a*f)
                deter[2][0] = (d*h) - (e*g)
                deter[2][1] = (b*g) - (a*h)
                deter[2][2] = (a*e) - (b*d)

                xyz = 1 / ((a*e*i) + (b*f*g) + (c*d*h) - (b*d*i) - (a*f*h) - (c*e*g))

                for um in deter:
                    for ut in range(len(um)):
                        um[ut] *= xyz
            if "txt" not in sys.argv[3]:
                print("Ciphertext file could not be read")
            with open(sys.argv[3]) as gun:
                go = gun.read()
            gor = go.split(",")
            for i in range(len(gor)):
                gor[i] = int(gor[i])

            detered = [gor[x:x+len(deter)] for x in range(0, len(gor), len(deter))]
            deter_b = [[j] for i in detered for j in i]
            deter_a = [deter_b[y:y+len(deter)] for y in range(0, len(deter_b), len(deter))]

            sonuc = [[0] for i in range(len(deter))]
            decrypted_list = []
            for ma2 in deter_a:
                for i in range(len(deter)):
                    for j in range(len(ma2[0])):
                        for k in range(len(ma2)):
                            sonuc[i][j] += deter[i][k] * ma2[k][j]
                decrypted_list.append(sonuc)
                sonuc = [[0] for i in range(len(deter))]


            son_liste = []
            for i in decrypted_list:
                for j in i:
                    for k in j:
                        son_liste.append(k)

            st = ""
            for elem in son_liste:
                st += dict2[elem]

            nam = open(sys.argv[4], "w")
            nam.write(st)
            nam.close()



        else:
            print("Undefined parameter error")

    except FileNotFoundError:
        print("Input file not found error")
    except KeyError:
        print("Invalid character in input file error")
    except ZeroDivisionError:
        print("Key file is empty error")
    except ValueError:
        print("Invalid character in key file error")
else:
    print("Parameter number error")