import java.nio.charset.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.io.*;

class MyIO {

   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

   public static void print(){
   }

   public static void print(int x){
      System.out.print(x);
   }

   public static void print(double x){
      System.out.print(x);
   }

   public static void print(String x){
      System.out.print(x);
   }

   public static void print(boolean x){
      System.out.print(x);
   }

   public static void println(){
   }

   public static void println(int x){
      System.out.println(x);
   }

   public static void println(double x){
      System.out.println(x);
   }

   public static void println(String x){
      System.out.println(x);
   }

   public static void println(boolean x){
      System.out.println(x);
   }

   public static double readDouble(){
      double d = -1;
      try{
         d = Double.parseDouble(readString().trim());
      }
      catch(Exception e){}
      return d;
   }

   public static double readDouble(String str){
      System.out.print(str);
      return readDouble();
   }

   public static float readFloat(){
      return (float) readDouble();
   }

   public static float readFloat(String str){
      return (float) readDouble(str);
   }

   public static int readInt(){
      int i = -1;
      try{
         i = Integer.parseInt(readString().trim());
      }
      catch(Exception e){}
      return i;
   }

   public static int readInt(String str){
      System.out.print(str);
      return readInt();
   }

   public static String readString(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != ' ' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n' && tmp != ' ');
      }
      catch(IOException ioe){
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str){
      System.out.print(str);
      return readString();
   }

   public static String readLine(){
      String s = "";
      char tmp;
      try{
         do{
            tmp = (char)in.read();
            if(tmp != '\n' && tmp != 13){
               s += tmp;
            }
         }while(tmp != '\n');
      }
      catch(IOException ioe){
         System.out.println(" lerPalavra:: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str){
      System.out.print(str);
      return readLine();
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp = readString().charAt(0);
      }
      catch(Exception e){}
      return resp;
   }

   public static char readChar(String str){
      System.out.print(str);
      return readChar();
   }

   public static boolean readBoolean(){
      boolean resp = false;
      String str = "";
   
      try{
         str = readString();
      }
      catch(Exception e){}
   
      if(str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") || 
         str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")){
         resp = true;
      }
   
      return resp;
   }

   public static boolean readBoolean(String str){
      System.out.print(str);
      return readBoolean();
   }

   public static void pause(){
      try{
         in.read();
      }
      catch(Exception e){}
   }

   public static void pause(String str){
      System.out.print(str);
      pause();
   }
}
//---------------------------------------------------------------------------------
class Arq{
   private static boolean write = false;
   private static boolean read = false;
   private static Formatter saida = null;
   private static Scanner entrada = null;

   public static void openWrite(String nomeArq) {
      close();
   
      try{
         saida = new Formatter(nomeArq);
         write = true;
      }  
      catch (Exception e) {}
   }

   public static void openRead(String nomeArq) {
      close();
   
      try{
         entrada = new Scanner(new File(nomeArq));
         read = true;
      }  
      catch (Exception e) {}
   }

   public static void volta(String arq, long time){
      File file = new File(arq);
      long antes = file.lastModified();
      file.setLastModified(file.lastModified() - time);
   
      file = new File(arq);
      long depois = (new File(arq)).lastModified();
   
      System.out.println(arq + " " +antes +  " " + depois);
   }

   public static void setDataModificado(String nomeArq, int ano, int mes, int dia, int hora, int minuto, int segundo){
      String data = Integer.toString(ano);
      data += ((mes < 10)     ? "0" : "") + Integer.toString(mes);
      data += ((dia < 10)     ? "0" : "") + Integer.toString(dia);
      data += ((hora < 10)    ? "0" : "") + Integer.toString(hora);
      data += ((minuto < 10)  ? "0" : "") + Integer.toString(minuto);
      data += ".";
      data += ((segundo < 10) ? "0" : "") + Integer.toString(segundo);
      try {
         Process p = Runtime.getRuntime().exec("touch -m -t " + data + " " + nomeArq);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static void setDataAcesso(String nomeArq, int ano, int mes, int dia, int hora, int minuto, int segundo){
      String data = Integer.toString(ano);
      data += ((mes < 10)     ? "0" : "") + Integer.toString(mes);
      data += ((dia < 10)     ? "0" : "") + Integer.toString(dia);
      data += ((hora < 10)    ? "0" : "") + Integer.toString(hora);
      data += ((minuto < 10)  ? "0" : "") + Integer.toString(minuto);
      data += ".";
      data += ((segundo < 10) ? "0" : "") + Integer.toString(segundo);
      try {
         Process p = Runtime.getRuntime().exec("touch -a -t " + data + " " + nomeArq);
      } 
      catch (Exception e) {
         System.out.println("Error... setDataAcesso...");
         e.printStackTrace();
      }
   }

   public static void setPermissao(String nomeArq, int permissao){
      try {
         Process p = Runtime.getRuntime().exec("chmod " + permissao + " " + nomeArq);
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public static String getAbsolutePath(String nomeArquivo){
      return (new File(nomeArquivo)).getAbsolutePath();
   }


   public static String getCanonicalPath(String nomeArquivo){
      String resp = "";
      try {
         resp = (new File(nomeArquivo)).getCanonicalPath();
      } 
      catch (Exception e) {}
      return resp;
   }


   public static String getName(String nomeArquivo){
      return (new File(nomeArquivo)).getName();
   }


   public static String getParent(String nomeArquivo){
      return (new File(nomeArquivo)).getParent();
   }


   public static String getPath(String nomeArquivo){
      return (new File(nomeArquivo)).getPath();
   }


   public static void close() {
      if(write == true){
         saida.close();
         write = false;
      }
      if(read == true){
         entrada.close();
         read = false;
      }
   }

   public static void print(int x){
      if(write == true){
         saida.format( "%d", x);
      }
   }

   public static void print(double x){
      if(write == true){
         saida.format( "%f", x);
      }
   }

   public static void print(String x){
      if(write == true){
         saida.format( "%s", x);
      }
   }

   public static void print(boolean x){
      if(write == true){
         saida.format( "%s", ((x) ? "true" : "false"));
      }
   }

   public static void print(char x){
      if(write == true){
         saida.format( "%c", x);
      }
   }

   public static void println(int x){
      if(write == true){
         saida.format( "%d\n", x);
      }
   }

   public static void println(double x){
      if(write == true){
         saida.format( "%f\n", x);
      }
   }

   public static void println(String x){
      if(write == true){
         saida.format( "%s\n", x);
      }
   }

   public static void println(boolean x){
      if(write == true){
         saida.format( "%s\n", ((x) ? "true" : "false"));
      }
   }

   public static void println(char x){
      if(write == true){
         saida.format( "%c\n", x);
      }
   }

   public static int readInt(){
      int resp = -1;
      try{
         resp = entrada.nextInt();
      }  
      catch (Exception e) {}
      return resp;
   }

   public static char readChar(){
      char resp = ' ';
      try{
         resp = entrada.next().charAt(0);
      }  
      catch (Exception e) {}
      return resp;
   }

   public static double readDouble(){
      double resp = -1;
      try{
         resp = entrada.nextDouble();
      }  
      catch (Exception e) {}
      return resp;
   }

   public static String readString(){
      String resp = "";
      try{
         resp = entrada.next();
      }  
      catch (Exception e) {}
      return resp;
   }

   public static boolean readBoolean(){
      boolean resp = false;
      try{
         resp = (entrada.next().equals("true")) ? true : false;
      }  
      catch (Exception e) {}
      return resp;
   }

   public static String readLine(){
      String resp = "";
      try{
         resp = entrada.nextLine();
      }  
      catch (Exception e) {}
      return resp;
   }


   public static boolean hasNext(){
      return entrada.hasNext();
   }
}
//---------------------------------------------------------------------------------
class PropriedadeArquivo {
   private String ip;
   private String nome;
   private String caminho;
   private String permissao;
   private int tamanho;
   private Date dataAcesso;
   private Date dataModificado;
   private String dono;

   public PropriedadeArquivo (){
      ip = nome = caminho = permissao = dono = "";
      tamanho = 0;
      dataAcesso = new Date();
      dataModificado = new Date();
   }

   public PropriedadeArquivo (String nomeArquivo){
      ip = "127.1.1.1";
      nome = Arq.getName(nomeArquivo);
      caminho = Arq.getAbsolutePath(nomeArquivo);
   
      try {
      
         Process p = Runtime.getRuntime().exec("ls -l --full-time " + nomeArquivo);
         BufferedReader leitor = new BufferedReader(new InputStreamReader(p.getInputStream()));
         String propriedade = leitor.readLine();
      
         String tmp = "" + propriedade.charAt(0);
         for(int i = 1; i < propriedade.length(); i++){
            if(propriedade.charAt(i) != ' '){
               tmp += propriedade.charAt(i);
            }
            else if (tmp.charAt(tmp.length()-1) != ' '){
               tmp += ' ';
            }
         }
         propriedade = tmp;
      
         String[] vet = propriedade.split(" ");
      
      
         //[0] - Permissao
         int user =  (int)Math.pow(2,0) * ((vet[0].charAt(9) == 'x') ? 1 : 0) + 
                     (int)Math.pow(2,1) * ((vet[0].charAt(8) == 'w') ? 1 : 0) + 
                     (int)Math.pow(2,2) * ((vet[0].charAt(7) == 'r') ? 1 : 0); 
      
         int group = (int)Math.pow(2,0) * ((vet[0].charAt(6) == 'x') ? 1 : 0) + 
                     (int)Math.pow(2,1) * ((vet[0].charAt(5) == 'w') ? 1 : 0) + 
                     (int)Math.pow(2,2) * ((vet[0].charAt(4) == 'r') ? 1 : 0);
      
         int other = (int)Math.pow(2,0) * ((vet[0].charAt(3) == 'x') ? 1 : 0) + 
                     (int)Math.pow(2,1) * ((vet[0].charAt(2) == 'w') ? 1 : 0) + 
                     (int)Math.pow(2,2) * ((vet[0].charAt(1) == 'r') ? 1 : 0);
         
         int permissaoInt = user + group * 10 + other * 100;
         if(permissaoInt < 10){
            permissao = "00" + permissaoInt;
         } 
         else if(permissaoInt < 100){
            permissao = "0" + permissaoInt;
         } 
         else {
            permissao = "" + permissaoInt;
         }
      
         dono = vet[2];
         tamanho = Integer.parseInt(vet[4]);
         int ano = Integer.parseInt(vet[5].substring(0,4));
         int mes = Integer.parseInt(vet[5].substring(5,7));
         int dia = Integer.parseInt(vet[5].substring(8,10));
         int hora = Integer.parseInt(vet[6].substring(0,2));
         int minuto = Integer.parseInt(vet[6].substring(3,5));
         int segundo = Integer.parseInt(vet[6].substring(6,8));
      
         Calendar c = Calendar.getInstance();
         c.set(ano, mes - 1, dia, hora, minuto);
         dataModificado = c.getTime();
      
         p = Runtime.getRuntime().exec("ls -u -l --full-time " + nomeArquivo);
         leitor = new BufferedReader(new InputStreamReader(p.getInputStream()));
         propriedade = leitor.readLine();
         tmp = "" + propriedade.charAt(0);
         for(int i = 1; i < propriedade.length(); i++){
            if(propriedade.charAt(i) != ' '){
               tmp += propriedade.charAt(i);
            }
            else if (tmp.charAt(tmp.length()-1) != ' '){
               tmp += ' ';
            }
         }
         propriedade = tmp;
         vet = propriedade.split(" ");
         ano = Integer.parseInt(vet[5].substring(0,4));
         mes = Integer.parseInt(vet[5].substring(5,7));
         dia = Integer.parseInt(vet[5].substring(8,10));
         hora = Integer.parseInt(vet[6].substring(0,2));
         minuto = Integer.parseInt(vet[6].substring(3,5));
         segundo = Integer.parseInt(vet[6].substring(6,8));
      
         c.set(ano, mes - 1, dia, hora, minuto);
         dataAcesso = c.getTime();
      
      } 
      catch (Exception e) {
         e.printStackTrace();
      }
   }

   public PropriedadeArquivo clone (){
      PropriedadeArquivo pa = new PropriedadeArquivo();
      pa.ip = this.ip;
      pa.nome = this.nome;
      pa.caminho = this.caminho;
      pa.permissao = this.permissao;
      pa.tamanho = this.tamanho;
      pa.dataAcesso = this.dataAcesso;
      pa.dataModificado = this.dataModificado;
      pa.dono = this.dono;
      return pa;
   }

   public String toString(Date d){
      return (new SimpleDateFormat("dd/MM/yyyy hh:mm")).format(d);
   }

   public void imprimir(){
      System.out.println(ip + " " + nome + " " + permissao + " " + tamanho + " " + toString(dataModificado) + " " + toString(dataAcesso));
   }

   public String getIp(){
      return ip;
   }

   public void setIp(String ip){
      this.ip = ip;
   } 

   public String getNome(){
      return nome;
   }

   public void setNome(String nome){
      this.nome = nome;
   }

   public String getCaminho(){
      return caminho;
   } 

   public void setCaminho(String caminho){
      this.caminho = caminho;
   } 

   public String getPermissao(){
      return permissao;
   }

   public void setPermissao(String permissao){
      this.permissao = permissao;
   }

   public int getTamanho(){
      return tamanho;
   }

   public void setTamanho(int tamanho){
      this.tamanho = tamanho;
   } 

   public Date getDataAcesso(){
      return dataAcesso;
   }

   public void setDataAcesso(Date dataAcesso){
      this.dataAcesso = dataAcesso;
   }

   public Date getDataModificado(){
      return dataModificado;
   }

   public void setDataModificado(Date dataModificado){
      this.dataModificado = dataModificado;
   }

   public String getDono(){
      return dono;
   }

   public void setDono(String dono){
      this.dono = dono;
   } 
}
//---------------------------------------------------------------------------------
class No {
    public PropriedadeArquivo elemento; // Conteudo do no.
    public No esq; // No da esquerda.
    public No dir; // No da direita.
    public int nivel; //Numero de niveis abaixo do no
 
   /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     */
    No(PropriedadeArquivo elemento) {
      this(elemento, null, null, 1);
    }
 
    /**
     * Construtor da classe.
     * @param elemento Conteudo do no.
     * @param esq No da esquerda.
     * @param dir No da direita.
     */
    No(PropriedadeArquivo elemento, No esq, No dir, int nivel) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
   }
 
   // Cálculo do número de níveis a partir de um vértice
   public No setNivel() {
      this.nivel = 1 + Math.max(getNivel(esq),getNivel(dir));
      return this;
   }
 
   // Retorna o número de níveis a partir de um vértice 
   public static int getNivel(No no) {
      return (no == null) ? 0 : no.nivel;
   }
}
//---------------------------------------------------------------------------------

/**
 * AVL - Árvore Binária de Pesquisa com algoritmo de balanceamento AVL.
 * @author Max do Val Machado
 */
class AVL {
    private No raiz; // Raiz da arvore.
 
    /**
     * Construtor da classe.
     */
    public AVL() {
        raiz = null;
    }
 
   public int getAltura() {
      return nivel(raiz) - 1;
   }
 
   private int nivel(No no){
      return (no == null) ? 0 : (1 + Math.max(nivel(no.esq), nivel(no.dir)));
   }
 
    /**
     * Metodo publico iterativo para pesquisar elemento.
     * @param elemento Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String x) {
        System.out.print("raiz ");
        return pesquisar(raiz, x);
    }
 
    /**
     * Metodo privado recursivo para pesquisar elemento.
     * @param no No em analise.
     * @param x Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     * <code>false</code> em caso contrario.
     */
    private boolean pesquisar(No no, String x) {
      boolean resp;
        if (no == null) {
         resp = false;
         
      } else if (x.equals(no.elemento.getNome())) {
         resp = true;

      } else if (x.compareTo(no.elemento.getNome()) < 0) {
         System.out.print("esq ");
         resp = pesquisar(no.esq, x);
 
      } else {
         System.out.print("dir ");
         resp = pesquisar(no.dir, x);
      }
      return resp;
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarCentral() {
        System.out.print("[ ");
        mostrarCentral(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param no No em analise.
     */
    private void mostrarCentral(No no) {
        if (no != null) {
            mostrarCentral(no.esq); // Elementos da esquerda.
            System.out.print(no.elemento + " "); // Conteudo do no.
            mostrarCentral(no.dir); // Elementos da direita.
        }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPre() {
        System.out.print("[ ");
        mostrarPre(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param no No em analise.
     */
    private void mostrarPre(No no) {
        if (no != null) {
            System.out.print(no.elemento + " "); // Conteudo do no.
            mostrarPre(no.esq); // Elementos da esquerda.
            mostrarPre(no.dir); // Elementos da direita.
        }
    }
 
    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void mostrarPos() {
        System.out.print("[ ");
        mostrarPos(raiz);
        System.out.println("]");
    }
 
    /**
     * Metodo privado recursivo para exibir elementos.
     * @param no No em analise.
     */
    private void mostrarPos(No no) {
        if (no != null) {
            mostrarPos(no.esq); // Elementos da esquerda.
            mostrarPos(no.dir); // Elementos da direita.
            System.out.print(no.elemento + " "); // Conteudo do no.
        }
    }
 
 
    /**
     * Metodo publico iterativo para inserir elemento.
     * @param x Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
     void inserir(PropriedadeArquivo x) throws Exception {
        raiz = inserir(raiz, x);
    }
 
    /**
     * Metodo privado recursivo para inserir elemento.
     * @param no No em analise.
     * @param x Elemento a ser inserido.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */
    private No inserir(No no, PropriedadeArquivo x) throws Exception {
          if (no == null) {
         no = new No(x);
 
      } else if (x.getNome().compareTo(no.elemento.getNome()) < 0) {
         no.esq = inserir(no.esq, x);
 
      } else if (x.getNome().compareTo(no.elemento.getNome()) > 0) {
         no.dir = inserir(no.dir, x);
 
      } else {
         throw new Exception("Erro ao inserir!");
      }
        no = balancear(no);
        return no;
    }
 
   private No balancear(No no) throws Exception {
      if(no != null){
         int fator = No.getNivel(no.dir) - no.getNivel(no.esq);
 
         //Se balanceada
         if (Math.abs(fator) <= 1){
            no = no.setNivel();
 
         //Se desbalanceada para a direita
         }else if (fator == 2){
 
            int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
 
            //Se o filho a direita tambem estiver desbalanceado
            if (fatorFilhoDir == -1) {
               no.dir = rotacionarDir(no.dir);
            }
            no = rotacionarEsq(no);
 
         //Se desbalanceada para a esquerda
         }else if (fator == -2){
 
            int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
 
            //Se o filho a esquerda tambem estiver desbalanceado
            if (fatorFilhoEsq == 1) {
               no.esq = rotacionarEsq(no.esq);
            }
            no = rotacionarDir(no);
 
         }else{
            throw new Exception("Erro fator de balanceamento (" + fator + ") invalido!"); 
         }
      }
 
      return no;
   }
 
   private No rotacionarDir(No no) {
     // System.out.println("Rotacionar DIR(" + no.elemento.getNomeArquivo() + ")");
      No noEsq = no.esq;
      No noEsqDir = noEsq.dir;
 
      noEsq.dir = no;
      no.esq = noEsqDir;
 
      no.setNivel();
      noEsq.setNivel();
 
      return noEsq;
   }
 
   private No rotacionarEsq(No no) {
     // System.out.println("Rotacionar ESQ(" + no.elemento.getNomeArquivo() + ")");
      No noDir = no.dir;
      No noDirEsq = noDir.esq;
 
      noDir.esq = no;
      no.dir = noDirEsq;
 
      no.setNivel();
      noDir.setNivel();
      return noDir;
   }
 
    /**
     * Metodo publico iterativo para remover elemento.
     * @param elemento Elemento a ser removido.
     * @throws Exception Se nao encontrar elemento.
     */
    public void remover(PropriedadeArquivo x) throws Exception {
        raiz = remover(raiz, x);
    }
 
    /**
     * Metodo privado recursivo para remover elemento.
     * @param no No em analise.
     * @param x Elemento a ser removido.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se nao encontrar elemento.
     */
    private No remover(No no, PropriedadeArquivo x) throws Exception {
 
        if (no == null) {
         throw new Exception("Erro ao remover!");
 
      } else if (x.getNome().compareTo(no.elemento.getNome()) < 0) {
         no.esq = remover(no.esq, x);
 
      } else if (x.getNome().compareTo(no.elemento.getNome()) > 0) {
         no.dir = remover(no.dir, x);
 
      // Sem no a direita.
      } else if (no.dir == null) {
         no = no.esq;
 
      // Sem no a esquerda.
      } else if (no.esq == null) {
         no = no.dir;
 
      // No a esquerda e no a direita.
      } else {
         no.esq = antecessor(no, no.esq);
        }
        no = balancear(no);
        return no;
    }
 
    /**
     * Metodo para trocar no removido pelo antecessor.
     * @param n1 No que teve o elemento removido.
     * @param n2 No da subarvore esquerda.
     * @return No em analise, alterado ou nao.
     */
    private No antecessor(No n1, No n2) {
 
      // Existe no a direita.
        if (n2.dir != null) { 
         // Caminha para direita.
            n2.dir = antecessor(n1, n2.dir); 
 
      // Encontrou o maximo da subarvore esquerda.
        } else { 
            n1.elemento = n2.elemento; // Substitui N1 por N2.
            n2 = n2.esq; // Substitui N2 por N2.ESQ.
        }
        return n2;
    }


    void questao1() throws Exception{
  	
     AVL tree = new AVL();

        for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =  		    MyIO.readLine()){
    
          tree.inserir(new PropriedadeArquivo(nomeArquivo));

        }
	for(String nomeArquivo = MyIO.readLine(); nomeArquivo.equals("FIM") == false; nomeArquivo =  		    MyIO.readLine()){

        if( tree.pesquisar(nomeArquivo) == true )
        {
          System.out.println("SIM");
        }
        else
        {
          System.out.println("NAO");
        }
      }
    }
}

//---------------------------------------------------------------------------------
public class TP3Q3{
   public static void main (String args[]) throws Exception{
     
	AVL tree = new AVL();

  	tree.questao1();

   
     
   }
}
