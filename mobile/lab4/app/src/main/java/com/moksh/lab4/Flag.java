package com.moksh.lab4;

public class Flag {
    private int counter = 0;
    private String flag;

    public String Flag(){
        flag = "";
        return flag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        counter +=1;
        if(counter < 2){
            this.flag = flag;
        }

    }

    public String generateFlag(String flag){
        try{
            byte[] tmp = flag.getBytes("UTF-8");
            char [] res = new char[flag.length()];
            for(int i=0;i<flag.length();i++){
                if(i != flag.length() -1){
                    res[i] = (char)(tmp[i] + tmp[i+1] -1);
                }else{
                    res[i] = '}';
                }
            }
            return new String(tmp);
        }catch(Exception e){
            return "123";
        }
    }

}
