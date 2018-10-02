# Object-Oriented Software Testing

Master 1 ICE, GLa - V&V - Labs ([course materials](http://combemale.fr/teaching/m1ice/))

> Cr�ez un projet Java, r�cup�rez la classe MyPoint, et rajoutez la librairie JUnit � votre projet. 

- OK -

## Test Unitaire pour Java avec JUnit

> Q.1a Tester les constructeurs 1 et 2 (dans une classe de test TestMyPoint). Pour cela, utiliser la Javadoc pour
comprendre le comportement attendu des constructeurs. Utilisez des assertions pour v�rifier les valeurs, par exemple :

    ...
    assertEquals (0d, point . getX (), 0.0001);
    ...
- OK

> Q.1b Le test de ces constructeurs utilisent les op�rations getX et getY. Ne trouvez-vous pas cela �trange qu�un test utilise d�autres op�rations ? Que faire ?
- Non, puisque les attributs qui nous interessent sont private, il nous faut des getter et setter pour y acceder.

> Q.1c Testez les accesseurs en lecture et �criture (les op�rations get et set). Tout d�abord, testez getX et setX ensemble (car elles sont li�es, idem pour y). Ensuite cr�ez d�autres tests pour tester les op�rations set avec la valeur Double.NaN (cf. la javadoc de ces op�rations).

> Q.1d Testez le constructeur 3 et l�op�ration scale. Plusieurs tests (i.e. plusieurs op�rations) seront n�cessaires pour le constructeur 3. Vous pouvez constater que la plupart des tests n�cessitent la cr�ation d�un point au d�but des op�rations de test.

> Q.1e D�finissez et utilisez l�op�ration @Before setUp() et tout ce qui est �galement n�cessaire pour d�l�guer cette cr�ation � l�op�ration setUp.

> Q.1f Testez l�op�ration horizontalSymmetry. L� encore, plusieurs tests (i.e. plusieurs op�rations) seront n�cessaires. Vous remarquerez que cette op�ration peut lever une exception. Utilisez le param�tre expected de l�annotation Test pour v�rifier que cette exception est bien lev�e en temps voulu.

## Couverture de code

> Q.2a Utilisez l�outil de couverture de code fourni dans Eclipse (ou autre IDE) pour identifier les chemins dans le code non couvert par vos tests. Rajoutez quelques tests si besoins (n�y passez pas trop de temps).

> Q.2b Est-ce que votre code est s�r lorsque toutes les instructions sont couvertes par au moins un test ?

> Q.2c Ajoutez le test unitaire suivant et ex�cutez-le. S�il passe, bien jou�. Dans tout les cas cela peut certainement vous aidez � r�pondre � la question pr�c�dente.

    @Test public void testCentralSymmetryNULL ( ) {
        new MyPoint ( 1 0 , 2 0 ) . centralSymmetry ( null ) ;
    }

## Test d'int�gration pour Java avec EasyMock ou Mockito

Cet exercice est une br�ve introduction au principe du mock.

L�op�ration setPoint(Random r1, Random r2) d�finit les coordonn�es d�un point de mani�re al�atoire (x avec r1, et y avec r2).

> Q.3a Expliquez en quoi il est impossible de tester en l��tat cette op�ration.
    >> On veut donc utiliser le principe du Mock pour tester cette op�ration.

> Q.3b Utilisez Easymock ou Mockito pour tester cette op�ration. 

Avec Mockito :
- N�oubliez pas @RunWith (MockitoJUnitRunner.class). Vous aurez besoin de 2 attributs Random annot�e avec @Mock. Le but est de simuler l�op�ration nextInt(). 
- L�op�ration translate(ITranslation) d�place le point selon le vecteur de translation donn� en param�tre. Cependant ITranslation est une interface, on ne peut donc pas l�instancier.

Avec Easymock : voir la refcard et les slides du cours.

> Q.3c Supposons que nous ne disposons pas d�une impl�mentation de ITranslation pour tester cette op�ration, utilisez Mockito ou Easymock et tester finalement cette op�ration.

## Evaluation 

1. faite un fork du repo github
2. r�pondez aux questions (dans un nouveau fichier Markdown ou directement dans README.md), dans lequel vous pr�ciserez �galement les noms du binome.
3. rajoutez vos tests, modifications de la classe sous test, etc. 
4. soumettez votre pull request (qui servira � l'�valuation)
