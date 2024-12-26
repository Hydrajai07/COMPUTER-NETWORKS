package crc;
import java.util.*;
import java.io.*;
public class CRC
{
char t[]=new char[200];
char cs[]=new char[200];
char g[]=new char[200];
int a,e,c;
void xor()
{
for(int i=1;i<17;i++)
cs[i]=((cs[i]==g[i])?'0':'1');
}
void crc()
{
for(e=0;e<17;e++)
cs[e]=t[e];
do
{
if(cs[0]=='1')
xor();
for(c=0;c<16;c++)
cs[c]=cs[c+1];
cs[c]=t[e++];
}while(e<=a+16);
}
void operation()
{
Scanner read=new Scanner(System.in);
String msg;
String gs="10001000000100001";
for(int i=0;i<gs.length();i++)
g[i]=gs.charAt(i);
System.out.println("enter the polynomial");
msg=read.next();
for(int i=0;i<msg.length();i++)
t[i]=msg.charAt(i);
System.out.print("\n generating polynomial is=");
for(int i=0;i<gs.length();i++)
System.out.print(g[i]);
a=msg.length();
for(e=a;e<a+16;e++)
t[e]='0';
System.out.print(" \n Modified message is=");
for(int i=0;i<msg.length()+16;i++)
System.out.print(t[i]);
crc();
System.out.println("\n Checksum is:");
for(int i=0;i<16;i++)
System.out.print(cs[i]);
for(e=a;e<a+16;e++)
t[e]=cs[e-a];
System.out.println("\n final codeword is:");
for(int i=0;i<a+16;i++)
System.out.print(t[i]);
System.out.println("\nTest error detection 0(yes)/1(no):");
e=read.nextInt();
if(e==0)
{
System.out.println("\nenter the position where error is to be inserted:");
e=read.nextInt();
t[e]=(t[e]=='0')?'1':'0';
System.out.println("errornous data:") ;
for(int i=0;i<a+16;i++)
System.out.print(t[i]);
}
crc();
for(e=0;(e<16)&&(cs[e]!='1');e++);
if(e<16)
System.out.println("error detected");
else
System.out.println("no error detected");
}
public static void main(String[] args)
{
CRC ob=new CRC();
ob.operation();
}
}
