package assignment3;

public QuoteServerThread() throws IOException {
    this("QuoteServer");
}

public QuoteServerThread(String name) throws IOException {
    super(name);
    socket = new DatagramSocket(4445);

    try {
        in = new BufferedReader(new FileReader("one-liners.txt"));
    }   
    catch (FileNotFoundException e){
        System.err.println("Couldn't open quote file.  Serving time instead.");
    }
}  