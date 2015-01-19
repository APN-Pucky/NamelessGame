package de.neuwirthinformatik.Alexander.gl.obejct.D3;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

import de.neuwirthinformatik.Alexander.gl.GLGlobal;
import de.neuwirthinformatik.Alexander.gl.obejct.Drawable;
import de.neuwirthinformatik.Alexander.gl.obejct.Object3D;
import de.neuwirthinformatik.Alexander.gl.obejct.Renderable;
import de.neuwirthinformatik.Alexander.gl.obejct.Updateable;
import de.neuwirthinformatik.Alexander.gl.obejct.GL.PlayerGL;


public class Player3D extends Object3D implements Drawable,Updateable
{
	private double speed = 40;
	private double mouseSpeed = 1;
	//private static Vector3f rotation = new Vector3f(0,0,0);
	//												m30,m31,m32
	//private static Vector3f position = new Vector3f(0,0,0);
	//												m03,m13,m23
	public Player3D(double speed, double mousespeed)
	{
		this.speed = speed;
		this.mouseSpeed = mousespeed;
	}
	
	public void update(long delta)
	{
		if (Mouse.isGrabbed()) {
            float mouseDX = (float) (Mouse.getDX() * mouseSpeed * 0.16f);
            float mouseDY = (float) (Mouse.getDY() * mouseSpeed * 0.16f);
            if (m31 + mouseDX >= 360) {
                m31 = m31 + mouseDX - 360;
            } else if (m31 + mouseDX < 0) {
                m31 = 360 - m31 + mouseDX;
            } else {
                m31 += mouseDX;
            }
            if (m30 - mouseDY >= -90 && m30 - mouseDY <= 90) {
                m30 += -mouseDY;
            } else if (m30 - mouseDY < -90) {
                m30 = -90;
            } else if (m30 - mouseDY > 90) {
                m30 = 90;
            }
        }
        
        if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))GLGlobal.stop();
        
        
        boolean keyUp = Keyboard.isKeyDown(Keyboard.KEY_UP) || Keyboard.isKeyDown(Keyboard.KEY_W);
        boolean keyDown = Keyboard.isKeyDown(Keyboard.KEY_DOWN) || Keyboard.isKeyDown(Keyboard.KEY_S);
        boolean keyLeft = Keyboard.isKeyDown(Keyboard.KEY_LEFT) || Keyboard.isKeyDown(Keyboard.KEY_A);
        boolean keyRight = Keyboard.isKeyDown(Keyboard.KEY_RIGHT) || Keyboard.isKeyDown(Keyboard.KEY_D);
        boolean flyUp = Keyboard.isKeyDown(Keyboard.KEY_LSHIFT);
        boolean flyDown = Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
        boolean moveFaster = Keyboard.isKeyDown(Keyboard.KEY_E);
        boolean moveSlower = Keyboard.isKeyDown(Keyboard.KEY_Q);
        if (moveFaster && !moveSlower) {
            speed *= 4f;
        }
        if (moveSlower && !moveFaster) {
            speed /= 10f;
        }
        
        if (keyUp && keyRight && !keyLeft && !keyDown) {
            float angle = m31 + 45;
            Vector3f newPos = new Vector3f(m03,m13,m23);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            m23 = newPos.z;
            m03 = newPos.x;
        }
        if (keyUp && keyLeft && !keyRight && !keyDown) {
            float angle = m31 - 45;
            Vector3f newPos = new Vector3f(m03,m13,m23);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            m23 = newPos.z;
            m03 = newPos.x;
        }
        if (keyUp && !keyLeft && !keyRight && !keyDown) {
            float angle = m31;
            Vector3f newPos = new Vector3f(m03,m13,m23);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);

            newPos.z += adjacent;
            newPos.x -= opposite;
            m23 = newPos.z;
            m03 = newPos.x;
        }
        if (keyDown && keyLeft && !keyRight && !keyUp) {
            float angle = m31 - 135;
            Vector3f newPos = new Vector3f(m03,m13,m23);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            m23 = newPos.z;
            m03 = newPos.x;
        }
        if (keyDown && keyRight && !keyLeft && !keyUp) {
            float angle = m31 + 135;
            Vector3f newPos = new Vector3f(m03,m13,m23);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            m23 = newPos.z;
            m03 = newPos.x;
        }
        if (keyDown && !keyUp && !keyLeft && !keyRight) {
            float angle = m31;
            Vector3f newPos = new Vector3f(m03,m13,m23);
            float hypotenuse = (float) (-(speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            m23 = newPos.z;
            m03 = newPos.x;
        }
        if (keyLeft && !keyRight && !keyUp && !keyDown) {
            float angle = m31 - 90;
            Vector3f newPos = new Vector3f(m03,m13,m23);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            m23 = newPos.z;
            m03 = newPos.x;
        }
        if (keyRight && !keyLeft && !keyUp && !keyDown) {
            float angle = m31 + 90;
            Vector3f newPos = new Vector3f(m03,m13,m23);
            float hypotenuse = (float) ((speed * 0.0002f) * delta);
            float adjacent = hypotenuse * (float) Math.cos(Math.toRadians(angle));
            float opposite = (float) (Math.sin(Math.toRadians(angle)) * hypotenuse);
            newPos.z += adjacent;
            newPos.x -= opposite;
            m23 = newPos.z;
            m03 = newPos.x;
        }
        
        if (flyUp && !flyDown) {
            double newPosY = (speed * 0.0002) * delta;
            m13 -= newPosY;
        }
        if (flyDown && !flyUp) {
            double newPosY = (speed * 0.0002) * delta;
            m13 += newPosY;
        }
        if (moveFaster && !moveSlower) {
            speed /= 4f;
        }
        if (moveSlower && !moveFaster) {
            speed *= 10f;
        }
	}

	@Override
	public Renderable draw() 
	{
		return new PlayerGL(this);
	}
}
