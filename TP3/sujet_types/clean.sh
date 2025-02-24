find . -name "*.class" > rm.txt

for i in `cat rm.txt` 
do
	rm $i
done
rm -r parser 2>/dev/null

rm rm.txt
