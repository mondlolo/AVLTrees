javac *.java;
java DamAVLApp >> file.csv;
for 
  do 
    for line in file.csv
       do  #String fileName = String.format("file%s.csv",i);
            head -i file.csv; # >> fileName;
       done
  done 
