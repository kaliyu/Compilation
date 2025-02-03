VERSION=4.13.2

start="prog"
path="/home/o22100171@campus.univ-orleans.fr/Bureau/antlr-"$VERSION"-complete.jar"
#Vérifier que la librairie antlr est bien présente
if [ -f "$path" ]; then
	echo "antlr4 OK"
else
	echo "téléchargement antlr"
	curl -o $path https://www.antlr.org/download/antlr-$VERSION-complete.jar
fi


if [ $# -ne 2 ]; then 
	echo "2 arguments requis : nom de la grammaire (sans extension), puis fichier à tester"
fi

#ici le nom du premier nœud de la grammaire à reconnaître
#(pour un langage de programmation, c’est le nœud qui correspond à
#l’intégralité du programme à analyser syntaxiquement


export CLASSPATH=$path:$CLASSPATH

rm out/* 2>/dev/null

java -Xmx500M org.antlr.v4.Tool "$1.g4" -o out
javac out/*.java 

cd out
java -Xmx500M org.antlr.v4.gui.TestRig $1 $start <../$2 -gui

cd ..
rm -r out 2>/dev/null

