  import java.awt.event.*;
  import javax.swing.*;
  import java.util.*;
  import java.io.*;


  public class Notepad
  {
    public Notepad()
    {
      final JFrame frm = new JFrame("Notepad");
      final JTextArea txtarea = new JTextArea(5,5);
      JScrollPane scroll = new JScrollPane(txtarea);
      final JFileChooser fc= new JFileChooser();
      frm.setVisible(true);
      frm.setSize(480,360);
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frm.setLocationRelativeTo(null);
      JMenuBar mnu = new JMenuBar();
      frm.setJMenuBar(mnu);
      JMenu file = new JMenu("File");file.setMnemonic(KeyEvent.VK_F);
      JMenu edit = new JMenu("Edit");edit.setMnemonic(KeyEvent.VK_E);
      JMenu abt = new JMenu("About");abt.setMnemonic(KeyEvent.VK_A);
      mnu.add(file);
      mnu.add(edit);
      mnu.add(abt);
      JMenuItem ne=new JMenuItem("New"); ne.setMnemonic(KeyEvent.VK_N);
      JMenuItem open=new JMenuItem("Open");open.setMnemonic(KeyEvent.VK_O);
      JMenuItem save=new JMenuItem("Save");save.setMnemonic(KeyEvent.VK_S);
      JMenuItem exit=new JMenuItem("Exit");exit.setMnemonic(KeyEvent.VK_E);
      file.add(ne);
      file.add(open);
      file.add(save);
      file.addSeparator();
      file.add(exit);
      JMenuItem cut=new JMenuItem("Cut"); cut.setMnemonic('t');
      JMenuItem copy=new JMenuItem("Copy");copy.setMnemonic('C');
      JMenuItem paste=new JMenuItem("Paste");paste.setMnemonic('p');
      JMenuItem selectall=new JMenuItem("SelectAll");selectall.setMnemonic('a');   
      edit.add(cut);
      edit.add(copy);
      edit.add(paste);
      edit.addSeparator();
      edit.add(selectall);

      frm.add(scroll);
      ne.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
          txtarea.setText("");
        }
      });
      open.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
          int responce = fc.showOpenDialog(frm);
          if(responce == JFileChooser.APPROVE_OPTION)
          {
            File file = fc.getSelectedFile();
            txtarea.setText("");
            try
            (Scanner in = new Scanner(file)) {
              while(in.hasNext())
              {
                String line = in.nextLine();
                txtarea.append(line+"\n");
              }
            } catch (Exception ex)
            {
            }
          }
        }
      });

      save.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          int responce = fc.showSaveDialog(frm);
          if(responce == JFileChooser.APPROVE_OPTION)
          {
            File file = fc.getSelectedFile();
            PrintWriter out = null;
            try
            {
            out = new PrintWriter(file);
            String output = txtarea.getText();
            System.out.println(output);
            out.println(output);
            } catch (FileNotFoundException ex)
            {
            } finally
            {
              out.flush();
              out.close();
            }
          }
        }
      });

      exit.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          System.exit(0);
        }
      });
    }
    public static void main(String arg[])
    {
          Notepad notepad;
          notepad = new Notepad();

    }
  }
