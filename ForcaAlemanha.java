import javax.swing.*;               
import java.util.*;                 
import java.awt.*;                  
import java.awt.event.*;            

public class ForcaAlemanha extends JFrame {                        
	
	private JLabel lblTitulo,  lblImg, lblResultado, lblImgb;       
	private JButton btnStart; 
	
	Icon imagem[];  	//array []
	
	public ForcaAlemanha(){                                       
	
    lblTitulo = new JLabel("Henker Spiel");                 
	lblTitulo.setBounds(300,10,500,50); 
	lblTitulo.setFont(new Font("Arial",Font.BOLD, 40));
	add(lblTitulo); 
	
	imagem = new ImageIcon[8];                                  
	imagem[0] = new ImageIcon("imagens\\enforcado01.png");      
	imagem[1] = new ImageIcon("imagens\\enforcado02.png");
	imagem[2] = new ImageIcon("imagens\\enforcado03.png");
	imagem[3] = new ImageIcon("imagens\\enforcado04.png");
	imagem[4] = new ImageIcon("imagens\\enforcado05.png");
	imagem[5] = new ImageIcon("imagens\\enforcado06.png");
	imagem[6] = new ImageIcon("imagens\\enforcado07.png");
	imagem[7] = new ImageIcon("imagens\\enforcado08.png");  
	
	
	lblImg = new JLabel(imagem[0]);                              
	lblImg.setBounds(50,100,300,500); 
	add(lblImg);  
	
	
	lblResultado = new JLabel("");                  
	lblResultado.setBounds(350,150,500,50); 
	lblResultado.setFont(new Font("Arial", Font.BOLD, 40)); 
	add(lblResultado); 
	
	btnStart = new JButton("Spiel beginnen");                      
	btnStart.setBounds(550,260,250,50); 
	btnStart.setFont(new Font("Arial", Font.BOLD, 20)); 
	add(btnStart); 
	btnStart.addActionListener(
	    new ActionListener(){
			public void actionPerformed(ActionEvent e){
				startGame();
			}
			
		});
	
	}
	
public static void main (String args[]){                           
	
	ForcaAlemanha form = new ForcaAlemanha ();                     
	form.setLayout(null);                                          
	form.setBounds(0,0,900,700);                                     
	form.setLocationRelativeTo(null);                              
	form.setVisible(true);                                         
	form.setResizable(true);                                      
	form.setDefaultCloseOperation(EXIT_ON_CLOSE);                  
	form.setTitle("Henker Spiel- Jogo da Forca");                                
  } 

  private void startGame(){                                        
	  
	  String[] palavras ={"krankenschwester", "arzt", "herz", "spritze", "wurf", "ambulanz", "krankenhaus", "kochsalzlösung", "friedhof", "wagen", "schüler", "arbeiter", "bettler", "herzinfarkt", "blutung", "knochen", "verletzt", "hilfe", "tod", "gehirn", "lunge", "zucker"};
	  
	  lblImg.setIcon(imagem[0]);                                  
	  
	  Random aleatorio = new Random(new Random().nextLong());      
	  
	  int index = aleatorio.nextInt(palavras.length);               
	  
	  String palavraSelecionada = palavras[index];                 
       
      char[] traco = new char[palavraSelecionada.length()];        
      
      for (int i = 0; i < palavraSelecionada.length(); i++){     
	    traco[i] = '_';
	  }	   
	  int palavraString = palavras[index].length();                 
	                                         
	  int tentativas = 7, indexImagem = 1;                          
	  
	  while(palavraString > 0 && tentativas > 0){                   
		
        lblResultado.setText(""); 
		
		for(int i = 0; i < palavraSelecionada.length(); i++ ){                   
			lblResultado.setText(lblResultado.getText() + " " + traco[i] + " ");
		} 
		
		String mensagem = "";                                                    
		mensagem += "Sie haben " + tentativas + " chancen zu erraten\n";       
		mensagem += "Das wort hat " + palavraString + " restlichen buchstaben\n"; 
		mensagem += "Tippe einen buchstaben: \n"; 
		
		String letra = JOptionPane.showInputDialog(null, mensagem);            
		
		char letras = letra.charAt(0);                                         
		    
		boolean acertou = false;                                          	
		
		for (int i = 0; i < traco.length; i++){                   
			                                                      
		    if(palavras[index].charAt(i) == letras){             
				traco[i] = letras; 
				palavraString--; 
				acertou = true;
    }   }if(!acertou){                                       
				tentativas--; 
				lblImg.setIcon(imagem[indexImagem++]); 
				
			}
		
	} 
        if(palavraString == 0 ){
			
			lblResultado.setText(palavraSelecionada); 
			JOptionPane.showMessageDialog(null, "ALLES GUTE ZUM GEBURTSTAG!\nSie haben RECHT! \nDas richtige Wort war: " + palavraSelecionada);
			
		}else{ 
		  
		  JOptionPane.showMessageDialog(null, "Du hast leider verloren! \n \nDas richtige Wort war: " + palavraSelecionada);
			
		}		 
} 
}