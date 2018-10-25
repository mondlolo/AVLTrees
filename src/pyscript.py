file_name = open("DamLevel.csv","r")
array_file = file_name.readlines()
count_variable = 0
data_set_size = 211
new_file_name = ""
new_file_number = 0


while(True):
    new_file_number+=1
    new_file_name = "subset{}.txt".format(new_file_number)
    new_output_file = open(new_file_name,"a")
    if(count_variable>=data_set_size):
        break
    if(count_variable==200):
        count_variable+=11
    else:
        count_variable+=10
        #line =0

    for i in range(1,count_variable+1):
        #print(array_file[i])
        new_output_file.write(array_file[i])

    new_output_file.close()


    '''print("")
    print("END")
    print("")'''
