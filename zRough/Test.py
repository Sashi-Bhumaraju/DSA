def printThis(str):
     print(str)

def add(a,b):
    return a+b

def even_odd(num):
    if num % 2 == 0:
        return "even"
    else:
        return "odd"

def isPrime(num): 
    if num == 2:
        return "prime"
    elif num % 2 == 0 or num == 1:
        return "not prime"
    for i in range(2,num):
        if num % i == 0: 
            return "not prime"
    return "prime"    
        
    

value = add(1,2)
printThis( isPrime(151) )     

