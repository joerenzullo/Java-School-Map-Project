package Final;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MapPanel extends JPanel implements MouseListener
{
    public Image image;
    public List<Vertex> path;
    public int x, y;
    public Building[] buildings;
    boolean sourceClick;

    public MapPanel()
    {
        loadImage();
        path = new ArrayList<Vertex>();
        buildings = createBuildings();
        sourceClick = true;
        this.addMouseListener(this);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                                                RenderingHints.VALUE_ANTIALIAS_ON);
        /**
         *  Draws the background at the top left corner, 
         *  draws a black line over the path before drawing a smaller black one
         *  for increased visibility of the path line.
         */
        g2.drawImage(image, 0, 0, this);
        g2.setPaint(Color.black);
        g2.setStroke(new BasicStroke(5.f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        drawPath(g2);
        g2.setPaint(Color.red);
        g2.setStroke(new BasicStroke(3.f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER));
        drawPath(g2);


    }
    private void drawPath(Graphics2D g)
    {
        for(int i = 0; i < path.size()-1; i++)
        {
            g.drawLine(path.get(i).posx, path.get(i).posy, path.get(i+1).posx, path.get(i+1).posy);
        }
    }

    private void loadImage()
    {
        try
        {
            image = ImageIO.read(new File("pcc_campus.png"));
        }
        catch(IOException e)
        {
            System.out.println("How are you missing the image? Exiting.");
            System.exit(ERROR);
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) 
    {
        // TODO Auto-generated method stub
        x = arg0.getX();
        y = arg0.getY();
        if(sourceClick)
        {
            sourceClick = false;
            Final.Map.sourceString = Final.Map.user.findclosestVertexName(x, y);
            Final.Map.pathFind(Final.Map.sourceString, Final.Map.destinationString, Final.Map.user, Final.Map.panel);
        }
        else
        {
            sourceClick = true;
            Final.Map.destinationString = Final.Map.user.findclosestVertexName(x, y);
            Final.Map.pathFind(Final.Map.sourceString, Final.Map.destinationString, Final.Map.user, Final.Map.panel);
        }
        for(Building b : buildings)
        {
            if(b.isWithin(x, y))
            {
            //DEBUG: System.out.println(b.name); // PRINTS --------------------------------- LOOOK HERE.;
            String SQL = "SELECT * from courses WHERE Location LIKE '" + b.name + " %'";
            ArrayList<Course> Courses = Final.SQLiteJDBC.execute_sql(SQL);

            JFrame popup = new JFrame();
            popup.setSize(500, 400);
            popup.setTitle("Building Information");

            JPanel popupPanel = new JPanel();
            popup.add(popupPanel);


            JTextArea textarea = new JTextArea(30,30);
            JScrollPane scrollpane = new JScrollPane(textarea);
            textarea.setEditable(false);
            popupPanel.add(scrollpane);
            for (Course course : Courses)
            {
                textarea.append(course.CRN + " | " + course.Title + "\n");
            }

            popup.setVisible(true);
            }
        }
    }
	

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        // do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        // do nothing
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        // do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        // TODO Auto-generated method stub
        // do nothing
    }

    private Building[] createBuildings()
    {
        Building CC = new Building("CC", 95, 67, 153, 180);
        Building HH = new Building("HH", 191, 24, 224, 46);
        Building L = new Building("L", 173, 46, 240 ,110);
        Building D = new Building("D", 260, 70, 305, 125);
        Building E = new Building("E", 425, 70, 466, 125);
        Building LL = new Building("LL", 490, 62, 595, 125);
        Building IT = new Building("IT", 60, 205, 90, 350);
        Building B = new Building("B", 95, 195, 146, 240);
        Building G = new Building("G", 183, 183, 205, 200);
        Building R = new Building("R", 150, 200, 300, 230);
        Building Z = new Building("Z", 177, 232, 215, 250);
        Building C = new Building("C", 300, 140, 435, 240);
        Building U = new Building("U", 507, 155, 560, 275);
        Building UU = new Building("UU", 565, 180 , 610, 220);
        Building W = new Building("W", 111, 266, 182, 347);
        Building LP = new Building("LP", 240, 265, 260, 340);
        Building V = new Building("V", 315, 250, 442, 286);
        Building CA = new Building("Center", 315,290, 470, 350);
        Building P = new Building("P", 100, 387, 125, 307);
        Building O = new Building("O", 95, 405, 121, 430);
        Building FS = new Building("FS", 133, 366, 211, 426);
        Building FB = new Building("FB", 212, 383, 250, 425);
        Building FC = new Building("FC", 260, 265, 288, 411);
        Building GM = new Building("GM", 295, 365, 450, 410);
        Building Annex = new Building("Annex", 460, 370 , 495, 410);
        Building SV = new Building("SV", 525, 470, 665, 565);
        Building STAD = new Building("STAD", 258, 440, 500, 555);

        Building[] buildings = { CC, HH, L, D, E, LL, IT, B, G, R, Z, C, U, UU, W, LP, V, CA, P, O, FS, FB, FC, GM, Annex, SV, STAD};

        return buildings;
    }

}