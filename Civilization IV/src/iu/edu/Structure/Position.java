/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Structure;

/**
 *
 * @author Shrutika
 */
public class Position 
{

    // there will be row no and col no
    
    public Position(int r, int c) 
    { 
        this.r = r; this.c = c; 
    }

    protected int r;
    protected int c;

    
    public int getRow() 
    { 
        return r; 
    }

    public int getColumn() 
    { 
        return c; 
    }

    public boolean equals(Object o) 
    {
        if (o == null) 
        { 
            return false; 
        }
        if (o.getClass() != Position.class) 
        { 
            return false; 
        }
        Position other = (Position) o;
        return r==other.r && c==other.c;
    }


    public String toString() 
    {
        return "["+r+","+c+"]";
    }
}

