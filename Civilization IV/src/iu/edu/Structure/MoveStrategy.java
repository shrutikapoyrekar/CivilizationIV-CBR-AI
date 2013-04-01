/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iu.edu.Structure;

/**
 *
 * @author Shrutika
 */
public interface MoveStrategy 
{
    public boolean validateMove(Position from, Position to, int moveCount);
    /*
     * this method will tell us whther a move is valide or not
     */
}
