package org.example.Builder;

public class Header {

    String xpath1 = "asdfasdf";
    String xpath2 = "asdfasdf";
    String xpath3 = "asdfasdf";
    String xpath14 = "asdfasdf";
    String xpath5 = "asdfasdf";




    public static Bilder builder(){
        return new Header().new Bilder();
    }
    public class Bilder{

        public Header build(){
            return Header.this;
        }

        public Bilder setXpath1(String xpath1) {
            Header.this.xpath1 = xpath1;
            return this;
        }

        public Bilder setXpath2(String xpath2) {
            Header.this.xpath2 = xpath2;
            return this;
        }

        public Bilder setXpath3(String xpath3) {
            Header.this.xpath3 = xpath3;
            return this;
        }

        public Bilder setXpath14(String xpath14) {
            Header.this.xpath14 = xpath14;
            return this;
        }

        public Bilder setXpath5(String xpath5) {
            Header.this.xpath5 = xpath5;
            return this;
        }
    }


}
