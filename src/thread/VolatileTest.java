package thread;

public class VolatileTest {

    private volatile int i;

    public void plus() {
        i++;
    }
}

/*

  Last modified Nov 20, 2023; size 379 bytes
  MD5 checksum 35eb6f4b3bcca7f1f7328a66f61bf2d9
  Compiled from "VolatileTest.java"
public class thread.VolatileTest
  minor version: 0
  major version: 52
  flags: (0x0021) ACC_PUBLIC, ACC_SUPER
  this_class: #3                          // thread/VolatileTest
  super_class: #4                         // java/lang/Object
  interfaces: 0, fields: 1, methods: 2, attributes: 1
Constant pool:
   #1 = Methodref          #4.#17         // java/lang/Object."<init>":()V
   #2 = Fieldref           #3.#18         // thread/VolatileTest.i:I
   #3 = Class              #19            // thread/VolatileTest
   #4 = Class              #20            // java/lang/Object
   #5 = Utf8               i
   #6 = Utf8               I
   #7 = Utf8               <init>
   #8 = Utf8               ()V
   #9 = Utf8               Code
  #10 = Utf8               LineNumberTable
  #11 = Utf8               LocalVariableTable
  #12 = Utf8               this
  #13 = Utf8               Lthread/VolatileTest;
  #14 = Utf8               plus
  #15 = Utf8               SourceFile
  #16 = Utf8               VolatileTest.java
  #17 = NameAndType        #7:#8          // "<init>":()V
  #18 = NameAndType        #5:#6          // i:I
  #19 = Utf8               thread/VolatileTest
  #20 = Utf8               java/lang/Object
{
  public thread.VolatileTest();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 3: 0
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0       5     0  this   Lthread/VolatileTest;

  public void plus();
    descriptor: ()V
    flags: (0x0001) ACC_PUBLIC
    Code:
      stack=3, locals=1, args_size=1
         0: aload_0
         1: dup
         2: getfield      #2                  // Field i:I
         5: iconst_1
         6: iadd
         7: putfield      #2                  // Field i:I
        10: return
      LineNumberTable:
        line 8: 0
        line 9: 10
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      11     0  this   Lthread/VolatileTest;
}

 */