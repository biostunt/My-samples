
import random

def Sorting(temp):
    a = temp
    for i in range(int(len(a)/2)):
        for j in range(0+i, len(a)-i):
            if a[i] >= a[j]: ##change rotation of arrow
                a[i],a[j] = a[j], a[i]
            if a[int(len(a))-i-1] <= a[j]: ##change rotation of arrow
                a[int(len(a)) - i - 1], a[j] = a[j],a[int(len(a)) - i - 1]
    return a



a = []
key = "qwertyuiopasdfghjklzxcvbnm"
word = ["hello", "world", "type"]
for i in range(136):
    a.append(key[random.randint(0,len(key)-1)])
    ##a.append(word[random.randint(0, len(word) - 1)])
    ##a.append(random.randint(0,100000))
print(a)
a = Sorting(a)
print(a)
