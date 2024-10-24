����   B�
      javax/swing/JPanel <init> ()V	  	 
   
FlappyBird 
boardWidth I	     boardHeight	     birdX	     birdY	     	birdWidth	     
birdHeight	     pipeX	    !  pipeY	  # $  	pipeWidth	  & '  
pipeHeight	  ) *  	velocityX	  , -  	velocityY	  / 0  gravity 2 java/util/Random
 1 	  5 6 7 random Ljava/util/Random;	  9 : ; gameOver Z	  = > ? score D A java/awt/Dimension
 @ C  D (II)V
  F G H setPreferredSize (Ljava/awt/Dimension;)V
  J K L setFocusable (Z)V
  N O P addKeyListener (Ljava/awt/event/KeyListener;)V R javax/swing/ImageIcon
 T U V W X java/lang/Object getClass ()Ljava/lang/Class; Z ./flappybirdbg.png
 \ ] ^ _ ` java/lang/Class getResource "(Ljava/lang/String;)Ljava/net/URL;
 Q b  c (Ljava/net/URL;)V
 Q e f g getImage ()Ljava/awt/Image;	  i j k backGroundImg Ljava/awt/Image; m ./flappybird.png	  o p k birdImg r ./toppipe.png	  t u k 
topPipeImg w ./bottompipe.png	  y z k bottomPipeImg | FlappyBird$Bird
 { ~   (LFlappyBird;Ljava/awt/Image;)V	  � � � bird LFlappyBird$Bird; � java/util/ArrayList
 � 	  � � � pipes Ljava/util/ArrayList; � javax/swing/Timer � FlappyBird$1
 � �  � (LFlappyBird;)V
 � �  � #(ILjava/awt/event/ActionListener;)V	  � � � placePipesTimer Ljavax/swing/Timer;
 � � �  start	  � � � gameLoop
 � � � 6 � java/lang/Math ()D � FlappyBird$Pipe
 � ~	 � � �  y
 � � � � add (Ljava/lang/Object;)Z
  � � � paintComponent (Ljava/awt/Graphics;)V
  � � � draw
 � � � � � java/awt/Graphics 	drawImage 5(Ljava/awt/Image;IIIILjava/awt/image/ImageObserver;)Z	 { � � k img	 { � �  x	 { �	 { � �  width	 { � �  height
 � � � � size ()I
 � � � � get (I)Ljava/lang/Object;	 � �	 � �	 � �	 � �	 � � � � � java/awt/Color RED Ljava/awt/Color;
 � � � � setColor (Ljava/awt/Color;)V � java/awt/Font � Arial
 � �  � (Ljava/lang/String;II)V
 � � � � setFont (Ljava/awt/Font;)V
 � � � � � java/lang/String valueOf (I)Ljava/lang/String;   � � � makeConcatWithConstants &(Ljava/lang/String;)Ljava/lang/String;
 � � � � 
drawString	 � � � � WHITE � Press the space bar to contiue
 � � � � max (II)I	 �  ; passed?�      
  	colission %(LFlappyBird$Bird;LFlappyBird$Pipe;)Z	 ./flappingsound.wav
 \ getResourceAsStream )(Ljava/lang/String;)Ljava/io/InputStream;	 java/lang/System err Ljava/io/PrintStream;  �
 java/io/PrintStream println (Ljava/lang/String;)V java/io/BufferedInputStream
  (Ljava/io/InputStream;)V
!"#$% javax/sound/sampled/AudioSystem getAudioInputStream =(Ljava/io/InputStream;)Ljavax/sound/sampled/AudioInputStream;
!'() getClip ()Ljavax/sound/sampled/Clip;+,-./ javax/sound/sampled/Clip open )(Ljavax/sound/sampled/AudioInputStream;)V+ �2 java/lang/Exception
1456 
getMessage ()Ljava/lang/String;  �
19:  printStackTrace
 <=  move
 ?@  repaint
 �BC  stop
EFGH � java/awt/event/KeyEvent 
getKeyCode
 JK 	playSound
 �MN  clearP java/awt/event/ActionListenerR java/awt/event/KeyListener 	Signature (Ljava/util/ArrayList<LFlappyBird$Pipe;>; Code LineNumberTable LocalVariableTable this LFlappyBird; 
placePipes randompipeY openingSpace topPipe LFlappyBird$Pipe; 
bottomPipe g Ljava/awt/Graphics; pipe i StackMapTable a b audioSrc Ljava/io/InputStream; 
bufferedIn audioStream &Ljavax/sound/sampled/AudioInputStream; clip Ljavax/sound/sampled/Clip; e Ljava/lang/Exception; soundFileName Ljava/lang/String;s java/io/InputStream actionPerformed (Ljava/awt/event/ActionEvent;)V Ljava/awt/event/ActionEvent; 
keyPressed (Ljava/awt/event/KeyEvent;)V Ljava/awt/event/KeyEvent; keyTyped keyReleased 
SourceFile FlappyBird.java NestMembers BootstrapMethods� Game Over: � Sound file not found: � Error playing sound: �
��� �� $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses Bird Pipe� %java/lang/invoke/MethodHandles$Lookup� java/lang/invoke/MethodHandles Lookup !   OQ                j k     p k     u k     z k                                   !      $      '      � �     *      -      0      � � S   T   6 7     � �     � �     : ;     > ?        U  �    9*� *h� *�� **� l� **� l� *"� *� **� � *� *@� "* � %*�� (*� +*� .*� 1Y� 3� 4*� 8*� <*� @Y*� *� � B� E*� I**� M*� QY*� SY� [� a� d� h*� QY*� Sl� [� a� d� n*� QY*� Sq� [� a� d� s*� QY*� Sv� [� a� d� x*� {Y**� n� }� �*� �Y� �� �*� �Yܻ �Y*� �� �� �*� �� �*� �Y*� �� �*� �� ��   V   ~    P         '  -  3 - ; . @ / F 0 M B S C X D ] G h L m M r Q � S � T � V � W � X � Y � [ � \ ^ d# f1 g8 hW      9XY   Z  U   �     e*� *� %ld�� �*� %l�kg�<*� l=� �Y**� s� �N-� �*� �-� �W� �Y**� x� �:-� �*� %``� �*� �� �W�   V   & 	   l  m ! o . p 3 q < s J t Z u d vW   4    eXY    K[   ! D\   . 7]^  J _^   � � U   G     *+� �*+� ��   V       y  z 
 |W       XY     `a   � � U  r     �+*� h*� *� � �W+*� �� �*� �� �*� �� �*� �� �*� �� �� �W=*� �� Ȣ /*� �� �� �N+-� �-� �-� �-� �-� �� �W����+� Զ �+� �Y� � � �*� 8� =+*� <�� � �  
#� �+� �� �+� �Y�� � �+�2 �� � +*� <�� �
#� �   V   >      � = � J � V � p � v � } � � � � � � � � � � � � � � �W   *  V b^  ? 7c     �XY     �`a d    � ?� 6� W =  U  :     �*Y� +*� .`� +*� �Y� �*� +`� �*� �*� �� �� �� �<*� �� Ȣ q*� �� �� �M,Y� �*� (`� �,� �� '*� �� �,� �,� �`� ,� �*Y� <c� <**� �,�� *� 8*� �� �*� � *� 8�����   V   >    �  �  � / � < � H � U � o � t � � � � � � � � � � � � �W      H \b^  1 yc     �XY  d    � 1� N �� �   U   �     F+� �,� �,� �`� 7+� �+� �`,� Ѥ '+� �,� �,� �`� +� �+� �`,� �� � �   V       �W        FXY     Fe �    Ff^ d    � D@ K U  !     X*� S�
M,� �+�  ���Y,�N-� :�&:�* �0 � M�,�3�7  �,�8�     C1  @ C1 V   :    �  �  �  �  � % � + � 0 � 9 � @ � C � D � S � W �W   H   5gh  % ih  + jk  0 lm  D no    XXY     Xpq d    � r� &   � 1 tu U   o     *�;*�>*� 8� *� ��A*� ��A�   V       �  �  �  �  �  �W       XY     nv d     wx U   �     M+�D � F*�� +*�I*� 8� 2*� �*� � �*� +*� ��L*� <*� 8*� �� �*� �� ��   V   2    � 	 �  �  �  � ( � - � 4 � 9 � > � E � L �W       MXY     Mny d    � L zx U   5      �   V       �W       XY     ny  {x U   5      �   V       �W       XY     ny  |   }~     � { �    � �� �� ��   "  { �   �       � �  ��� 