package com.FireFerrariStudios.AlligatorFlip;

import android.content.Context;
import android.graphics.*;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by 1414125 on 5/12/2016.
 */
public class DrawView extends View {
    private Context myContext;
    private Bitmap frogBmp;
    private Bitmap firstBmp;
    private Bitmap soundONBmp;
    private Bitmap soundOFFBmp;
    private Bitmap secondBmp;
    private Bitmap thirdBmp;
    private Bitmap backgroundBmp;
    private Bitmap alligatorBmp;
    private Bitmap signBmp;
    private Bitmap fishBmp;
    private Bitmap crabBmp;
    private Bitmap birdBmp;
    private Bitmap hooksBmp;
    private Bitmap gfishBmp;
    private Bitmap homeHooksBmp;
    private Bitmap homeSignBmp;
    public boolean go=false;
    public boolean homes=true;
    public boolean play=false;
    public boolean gameover=false;
    public boolean donea=true;
    public boolean doneb=true;
    public boolean donec=true;
    public boolean doned=true;
    public boolean donee=true;
    public boolean donef=true;
    public boolean doneg=true;
    public boolean doneh=true;
    public boolean donei=true;
    public boolean donej=true;
    public boolean donek=true;
    public boolean donel=true;
    public boolean donem=true;
    public boolean donen=true;
    public boolean doneo=true;
    public boolean donep=true;
    public boolean doneq=true;
    public boolean doner=true;
    public boolean dones=true;
    public boolean donet=true;
    public boolean doneu=true;
    public boolean donev=true;
    public boolean donew=true;
    public boolean donex=true;
    public boolean doney=true;
    public boolean donez=true;
    public boolean all1=false;
    public boolean all2=false;
    public boolean all3=false;
    public boolean all4=false;
    public boolean all5=false;
    double ran;
    int touch=0;
    public boolean look=true;
    public boolean stuff=true;
    public boolean crab;
    public boolean bird;
    public  boolean fish;
    public boolean gfish;
    public boolean frog;
    public boolean tort=false;
    public boolean sc=false;
    public boolean tc=false;
    int a = 6;
    int b = 6;
    int c =-6;
    int d =-6;
    int e =100;
    RectF alligator = new RectF();
    RectF alligator1 = new RectF();
    RectF alligator2 = new RectF();
    RectF alligator3 = new RectF();
    RectF alligator4 = new RectF();
    RectF alligator5 = new RectF();
    boolean randomAnimalDrawn=false;
    RectF randomAnimal = new RectF();
    int count=0;
    int dx = 3, dy = 0;
    int startEx = -1, startEy = -1, endEx = -1, endEy = -1, sX=-1, sY=-1, mX=-1,mY=-1, q=-100,cX=-1,cY=-1;
    float p=100;
    int dir=2;
    int speedb;
    int extraA;
    private int highScore = 0;

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public DrawView(Context context) {
        super(context);
        backgroundBmp = BitmapFactory.decodeResource(getResources(), R.drawable.waves);
        alligatorBmp = BitmapFactory.decodeResource(getResources(), R.drawable.alligator);
        crabBmp = BitmapFactory.decodeResource(getResources(), R.drawable.crab);
        signBmp = BitmapFactory.decodeResource(getResources(), R.drawable.sign);
        hooksBmp = BitmapFactory.decodeResource(getResources(), R.drawable.hooks);
        homeHooksBmp = BitmapFactory.decodeResource(getResources(), R.drawable.hookopen);
        homeSignBmp = BitmapFactory.decodeResource(getResources(), R.drawable.signhome);
        birdBmp = BitmapFactory.decodeResource(getResources(), R.drawable.bird);
        fishBmp = BitmapFactory.decodeResource(getResources(), R.drawable.fish);
        gfishBmp = BitmapFactory.decodeResource(getResources(), R.drawable.goldfish);
        frogBmp = BitmapFactory.decodeResource(getResources(), R.drawable.frog);
        firstBmp = BitmapFactory.decodeResource(getResources(), R.drawable.first);
        secondBmp = BitmapFactory.decodeResource(getResources(), R.drawable.mid);
        thirdBmp = BitmapFactory.decodeResource(getResources(), R.drawable.last);
        soundOFFBmp = BitmapFactory.decodeResource(getResources(), R.drawable.soundoff);
        soundONBmp = BitmapFactory.decodeResource(getResources(), R.drawable.soundon);
        SoundPlayer.initSounds(getContext());
        myContext = context;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        alligator.set((float) .50 * right, (float) .50 * bottom, (float) .60 * right, (float) .60 * bottom);
        alligator1.set((float) .40 * right, (float) .50 * bottom, (float) .50 * right, (float) .60 * bottom);
        alligator3.set((float) .30 * right, (float) .50 * bottom, (float) .40 * right, (float) .60 * bottom);
        alligator3.set((float) .20 * right, (float) .50 * bottom, (float) .30 * right, (float) .60 * bottom);
        alligator4.set((float) .10 * right, (float) .50 * bottom, (float) .20 * right, (float) .60 * bottom);
        alligator5.set((float) .0 * right, (float) .50 * bottom, (float) .10 * right, (float) .60 * bottom);
        randomAnimal.set((float) .10 * right, (float) .10 * bottom, (float) .20 * right, (float) .20 * bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        RectF background = Draw.createRectF(0, 0, 100, 100, canvas);
        RectF sound = Draw.createRectF(0, 90, 6, 100, canvas);
        RectF hook = Draw.createRectF(0, q, 100, q+100, canvas);
        RectF sign = Draw.createRectF(0, p, 100, p+100, canvas);
        RectF tor = Draw.createRectF(8, 68, 35, 90, canvas);
        RectF single = Draw.createRectF(37, 44, 64, 65, canvas);
        RectF your = Draw.createRectF(55, p+40, 56, p+62, canvas);
        RectF high = Draw.createRectF(55, p+48, 56, p+70, canvas);
        RectF exit = Draw.createRectF(30, 85, 43, 100, canvas);
        RectF next = Draw.createRectF(57, 85, 73, 100, canvas);
        Paint cool = new Paint();
        cool.setColor(Color.BLACK);
        cool.setTextSize(30);
        Paint boy = new Paint();
        Typeface font1 = Typeface.createFromAsset(myContext.getAssets(), "Fonts/BerlinSansFBRegular.ttf");
        boy.setTypeface(font1);
        boy.setTextSize(30);
        boy.setColor(Color.rgb(2,59,2));
        RectF display = Draw.createRectF(90,80,100,90,canvas);

        if(count > highScore){
            highScore = count;
        }

        if (homes){
            sc=false;tc=false;
            if (q<=-1) {
                q = q +2;
            }
            if (p>=70) {
                p = p-45;
            }
            if (p<=66 && p>=6) {
                p = p-1;
            }
            canvas.drawBitmap(backgroundBmp, null, background, null);
            canvas.drawBitmap(homeHooksBmp, null, hook, null);
            canvas.drawBitmap(homeSignBmp, null, sign, null);

            invalidate();

            if(sound.contains(cX,cY) && look){
                touch++;
                look=false;
            }
            if (touch%2==0){
                canvas.drawBitmap(soundONBmp, null, sound, null);


            }
            if (!(touch%2==0)){
                canvas.drawBitmap(soundOFFBmp, null, sound, null);

            }
            if(single.contains(mX,mY)){
                if(touch%2==0) {
                    SoundPlayer.playSound(getContext(), 1);
                }
                homes=false;
                play=true;
                p=100;
                q=-100;
                invalidate();
            }
            if(tor.contains(mX,mY)){
                if(touch%2==0) {
                    SoundPlayer.playSound(getContext(), 1);
                }
                homes=false;
                tort=true;
                p=100;
                q=-100;
                invalidate();
            }

        }
//------------------------------------------------------------------------------------------------------

            if(tort){
                canvas.drawBitmap(firstBmp,null, background,null);
                if(sound.contains(cX,cY) && look){
                    touch++;
                    look=false;
                }
                if (touch%2==0){
                    canvas.drawBitmap(soundONBmp, null, sound, null);


                }
                if (!(touch%2==0)){
                    canvas.drawBitmap(soundOFFBmp, null, sound, null);

                }
                if (exit.contains(mX,mY)){
                    if(touch%2==0) {
                        SoundPlayer.playSound(getContext(), 1);
                    }
                    homes=true;
                    tort=false;
                    mX=-1;mY=-1;
                    invalidate();
                }
                if (next.contains(mX,mY) &&!sc&&!tc){
                    if(touch%2==0) {
                        SoundPlayer.playSound(getContext(), 1);
                    }
                    mX=-1;mY=-1;
                    sc=true;
                }
                if (sc){
                    canvas.drawBitmap(secondBmp,null,background,null);
                    if(sound.contains(cX,cY) && look){touch++;look=false;}
                    if (touch%2==0){canvas.drawBitmap(soundONBmp, null, sound, null);}
                    if (!(touch%2==0)){canvas.drawBitmap(soundOFFBmp, null, sound, null);}
                }
                if (exit.contains(mX,mY)){
                    if(touch%2==0) {
                        SoundPlayer.playSound(getContext(), 1);
                    }
                    mX=-1;mY=-1;
                    homes=true;
                    tort=false;
                    invalidate();
                }
                if (next.contains(mX,mY) &&sc &&!tc){
                    if(touch%2==0) {
                        SoundPlayer.playSound(getContext(), 1);
                    }
                    mX=-1;mY=-1;
                    tc=true;
                }
                if (tc){
                    canvas.drawBitmap(thirdBmp,null,background,null);
                    if(sound.contains(cX,cY) && look){touch++;look=false;}
                    if (touch%2==0){canvas.drawBitmap(soundONBmp, null, sound, null);}
                    if (!(touch%2==0)){canvas.drawBitmap(soundOFFBmp, null, sound, null);}
                }

            }

//------------------------------------------------------------------------------------------------------------------------------
        if (play) {
            canvas.drawBitmap(backgroundBmp, null, background, null);
            Draw.drawText(String.valueOf(count), display, cool, canvas);
            Draw.drawText(String.valueOf(speedb), 95,91,cool, canvas);
            Draw.drawText(String.valueOf(extraA), 95,98, cool, canvas);
            Draw.drawText("Score:", 87, 85, cool, canvas);
            Draw.drawText("Speed boost in _____ ", 77, 91, cool, canvas);
            Draw.drawText("Extra alligator in _____ ", 75, 98, cool, canvas);
            if(sound.contains(cX,cY) && look){touch++;look=false;}
            if (touch%2==0){canvas.drawBitmap(soundONBmp, null, sound, null);}
            if (!(touch%2==0)){canvas.drawBitmap(soundOFFBmp, null, sound, null);}
            if (!randomAnimalDrawn) {
                randomAnimal.offsetTo((int) (Math.random() * (getWidth() - randomAnimal.width())), (int) (Math.random() * (getHeight() - randomAnimal.height())));
                randomAnimalDrawn = true;

            }
            if (randomAnimalDrawn &&stuff) {
                stuff=false;
                ran = (int) (Math.random() * (6 - 1)) + 1;
                invalidate();
                if (ran == 2) {
                    crab=true;
                }
                else if (ran==1)  {
                    bird=true;
                }
                else if (ran==3)  {
                    fish=true;
                }
                else if (ran==4)  {
                    gfish=true;
                }
                else if (ran==5)  {
                    frog=true;
                }
                invalidate();
            }

            if(bird){
                canvas.drawBitmap(birdBmp, null, randomAnimal, null);
            }
            if (crab){
                canvas.drawBitmap(crabBmp, null, randomAnimal, null);

            }
            if (fish){
                canvas.drawBitmap(fishBmp, null, randomAnimal, null);

            }
            if (gfish){
                canvas.drawBitmap(gfishBmp, null, randomAnimal, null);

            }
            if (frog){
                canvas.drawBitmap(frogBmp, null, randomAnimal, null);

            }
            if (RectF.intersects(randomAnimal, alligator)) {
                if(touch%2==0) {
                    SoundPlayer.playSound(getContext(), 2);
                }
                count++;
                randomAnimalDrawn = false;
                stuff=true;
                crab=false;
                bird=false;
                fish=false;
                gfish=false;
                frog=false;

            }

            if (all1) {
                canvas.drawBitmap(alligatorBmp, null, alligator1, null);
            }
            if (all2) {
                canvas.drawBitmap(alligatorBmp, null, alligator2, null);
            }
            if (all3) {
                canvas.drawBitmap(alligatorBmp, null, alligator3, null);
            }
            if (all4) {
                canvas.drawBitmap(alligatorBmp, null, alligator4, null);
            }
            if (all5) {
                canvas.drawBitmap(alligatorBmp, null, alligator5, null);
            }

            if (dir == 1) {
                dx = 0;
                dy = c;

                alligator1.left = alligator.left;
                alligator1.top = alligator.top + 75;
                alligator1.right = alligator.right;
                alligator1.bottom = alligator.bottom + 75;

                alligator2.left = alligator.left;
                alligator2.bottom = alligator.bottom + 150;
                alligator2.right = alligator.right;
                alligator2.top = alligator.top + 150;

                alligator3.left = alligator.left;
                alligator3.bottom = alligator.bottom + 225;
                alligator3.right = alligator.right;
                alligator3.top = alligator.top + 225;

                alligator4.left = alligator.left;
                alligator4.bottom = alligator.bottom + 300;
                alligator4.right = alligator.right;
                alligator4.top = alligator.top + 300;
                alligator5.right = alligator.right;
                alligator5.top = alligator.top + 375;
                alligator5.left = alligator.left;
                alligator5.bottom = alligator.bottom + 375;

            }
            if (dir == 3) {
                dx = 0;
                dy = a;

                alligator1.left = alligator.left;
                alligator1.top = alligator.top - 75;
                alligator1.right = alligator.right;
                alligator1.bottom = alligator.bottom - 75;

                alligator2.left = alligator.left;
                alligator2.bottom = alligator.bottom - 150;
                alligator2.right = alligator.right;
                alligator2.top = alligator.top - 150;

                alligator3.left = alligator.left;
                alligator3.bottom = alligator.bottom - 225;
                alligator3.right = alligator.right;
                alligator3.top = alligator.top - 225;

                alligator4.left = alligator.left;
                alligator4.bottom = alligator.bottom - 300;
                alligator4.right = alligator.right;
                alligator4.top = alligator.top - 300;
                alligator5.right = alligator.right;
                alligator5.top = alligator.top -375;
                alligator5.left = alligator.left;
                alligator5.bottom = alligator.bottom - 375;

            }


            if (dir == 2) {
                dx = b;
                dy = 0;

                alligator1.right = alligator.right - 120;
                alligator1.top = alligator.top;
                alligator1.left = alligator.left - 120;
                alligator1.bottom = alligator.bottom;

                alligator2.right = alligator.right - 240;
                alligator2.top = alligator.top;
                alligator2.left = alligator.left - 240;
                alligator2.bottom = alligator.bottom;

                alligator3.right = alligator.right - 360;
                alligator3.top = alligator.top;
                alligator3.left = alligator.left - 360;
                alligator3.bottom = alligator.bottom;

                alligator4.right = alligator.right - 480;
                alligator4.top = alligator.top;
                alligator4.left = alligator.left - 480;
                alligator4.bottom = alligator.bottom;

                alligator5.right = alligator.right - 600;
                alligator5.top = alligator.top;
                alligator5.left = alligator.left - 600;
                alligator5.bottom = alligator.bottom;

            }
            if (dir == 4) {
                dx = d;
                dy = 0;

                alligator1.right = alligator.right + 120;
                alligator1.top = alligator.top;
                alligator1.left = alligator.left + 120;
                alligator1.bottom = alligator.bottom;

                alligator2.right = alligator.right + 240;
                alligator2.top = alligator.top;
                alligator2.left = alligator.left + 240;
                alligator2.bottom = alligator.bottom;

                alligator3.right = alligator.right + 360;
                alligator3.top = alligator.top;
                alligator3.left = alligator.left + 360;
                alligator3.bottom = alligator.bottom;

                alligator4.right = alligator.right + 480;
                alligator4.top = alligator.top;
                alligator4.left = alligator.left + 480;
                alligator4.bottom = alligator.bottom;

                alligator5.right = alligator.right + 600;
                alligator5.top = alligator.top;
                alligator5.left = alligator.left + 600;
                alligator5.bottom = alligator.bottom;
            }
            if(count==0) {speedb=5;extraA=5;}
            if(count==1) {speedb=4;extraA=4;}
            if(count==2) {speedb=3;extraA=3;}
            if(count==3) {speedb=2;extraA=2;}
            if(count==4) {speedb=1;extraA=1;}
            if(count==5) {speedb=5;extraA=5;}
            if(count==6) {speedb=4;extraA=4;}
            if(count==7) {speedb=3;extraA=3;}
            if(count==8) {speedb=2;extraA=2;}
            if(count==9) {speedb=1;extraA=1;}
            if(count==10) {speedb=5;extraA=5;}
            if(count==11) {speedb=4;extraA=4;}
            if(count==12) {speedb=3;extraA=3;}
            if(count==13) {speedb=2;extraA=2;}
            if(count==14) {speedb=1;extraA=1;}
            if(count==15) {speedb=5;extraA=5;}
            if(count==16) {speedb=4;extraA=4;}
            if(count==17) {speedb=3;extraA=3;}
            if(count==18) {speedb=2;extraA=2;}
            if(count==19) {speedb=1;extraA=1;}
            if(count==20) {speedb=1;extraA=10;}
            if(count==21) {speedb=1;extraA=9;}
            if(count==22) {speedb=1;extraA=8;}
            if(count==23) {speedb=1;extraA=7;}
            if(count==24) {speedb=1;extraA=6;}
            if(count==25) {speedb=1;extraA=5;}
            if(count==26) {speedb=1;extraA=4;}
            if(count==27) {speedb=1;extraA=3;}
            if(count==28) {speedb=1;extraA=2;}
            if(count==29) {speedb=1;extraA=1;}
            if(count==30) {speedb=1;extraA=10;}
            if(count==31) {speedb=1;extraA=9;}
            if(count==32) {speedb=1;extraA=8;}
            if(count==33) {speedb=1;extraA=7;}
            if(count==34) {speedb=1;extraA=6;}
            if(count==35) {speedb=1;extraA=5;}
            if(count==36) {speedb=1;extraA=4;}
            if(count==37) {speedb=1;extraA=3;}
            if(count==38) {speedb=1;extraA=2;}
            if(count==39) {speedb=1;extraA=1;}
            if(count==40) {speedb=1;extraA=10;}


            if (count >= 0) {
                canvas.drawBitmap(alligatorBmp, null, alligator, null);
            }
            if (count >= 5 && donea) {
                all1 = true;
                a = a + 2;
                b = b + 2;
                c = c - 2;
                d = d - 2;
                donea = false;
            }
            if (count >= 10 && doneb) {
                all2 = true;
                a = a + 2;
                b = b + 2;
                c = c - 2;
                d = d - 2;
                doneb = false;
            }
            if (count >= 15 && donec) {
                all3 = true;
                a = a + 2;
                b = b + 2;
                c = c - 2;
                d = d - 2;
                donec = false;
            }
            if (count >= 20 && doned) {
                all4 = true;
                a = a + 2;
                b = b + 2;
                c = c - 2;
                d = d - 2;
                doned = false;
            }
            if (count >= 21 && donee) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donee = false;
            }
            if (count >= 22 && donef) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donef = false;
            }
            if (count >= 23 && doneg) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                doneg = false;
            }
            if (count >= 24 && doneh) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                doneh = false;
            }
            if (count >= 25 && donei) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donei = false;
            }
            if (count >= 26 && donej) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donej = false;
            }
            if (count >= 27 && donek) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donek = false;
            }

            if (count >= 28 && donem) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donem = false;
            }
            if (count >= 29 && donen) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donen = false;
            }

            if (count >= 30 && donep) {
                all5 = true;
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donep = false;
            }
            if (count >= 31 && doneq) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                doneq = false;

            }
            if (count >= 32 && doner) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                doner = false;
            }
            if (count >= 33 && dones) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                dones = false;
            }
            if (count >= 34 && donet) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donet = false;
            }
            if (count >= 35 && doneu) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                doneu = false;
            }
            if (count >= 36 && donev) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donev = false;
            }
            if (count >= 37 && donew) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donew = false;
            }
            if (count >= 38 && donex) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donex = false;
            }
            if (count >= 39 && doney) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                doney = false;
            }
            if (count >= 40 && donez) {
                a = a + 1;
                b = b + 1;
                c = c - 1;
                d = d - 1;
                donez = false;
            }
            alligator.offset(dx, dy);
            invalidate();

        }
//-------------------------------------------------------------------------------------------------------------------------------------
        if (!background.contains(alligator)) {
            go = true;
        }
        if (go){
            gameover = true;
            go=false;
        }
        if (gameover){

            play=false;
            if (q<=-1) {
                q = q +2;
            }
            if (p>=70) {
                p = p-45;
            }
            if (p<=66 && p>=6) {
                p = p-1;
            }
            if (e>=-30){
                e=e-2;
            }

            canvas.drawBitmap(backgroundBmp, null, background, null);
            canvas.drawBitmap(hooksBmp, null, hook, null);
            canvas.drawBitmap(signBmp, null, sign, null);
            Draw.drawText(String.valueOf(count), your, boy, canvas);
            Draw.drawText(String.valueOf(highScore), high, boy, canvas);
            if(sound.contains(cX,cY) && look){touch++;look=false;}
            if (touch%2==0){canvas.drawBitmap(soundONBmp, null, sound, null);}
            if (!(touch%2==0)){canvas.drawBitmap(soundOFFBmp, null, sound, null);}

            randomAnimal.offsetTo(-200,-200);
            alligator.offsetTo(-200,-200);
            alligator1.offsetTo(-200,-200);
            alligator2.offsetTo(-200,-200);
            alligator3.offsetTo(-200,-200);
            alligator4.offsetTo(-200,-200);
            invalidate();

            if(e==-32) {
                RectF home1 = Draw.createRectF(8, 68, 35, 90, canvas);
                if (home1.contains(sX, sY)) {
                    if(touch%2==0) {
                        SoundPlayer.playSound(getContext(), 1);
                    }
                    gameover = false;
                    homes = true;
                    alligator.offsetTo(200, 200);
                    donea = true;
                    doneb = true;
                    donec = true;
                    doned = true;
                    donee = true;
                    donef = true;
                    doneg = true;
                    doneh = true;
                    donei = true;
                    donej = true;
                    donek = true;
                    donel = true;
                    donem = true;
                    donen = true;
                    doneo = true;
                    donep=true;
                    all1 = false;
                    all2 = false;
                    all3 = false;
                    all4 = false;
                    all5 = false;
                    a = 6;
                    b = 6;
                    c = -6;
                    d = -6;
                    randomAnimalDrawn = false;
                    count = 0;
                    dx = 3;
                    dy = 0;
                    q = -100;
                    p = 100;
                    e = 100;
                    invalidate();
                }
            }
            if(e==-32) {
                RectF again1 = Draw.createRectF(65, 68, 95, 90, canvas);
                if (again1.contains(sX, sY)) {
                    if(touch%2==0) {
                        SoundPlayer.playSound(getContext(), 1);
                    }
                    gameover = false;
                    play = true;
                    alligator.offsetTo(200, 200);
                    donea = true;
                    doneb = true;
                    donec = true;
                    doned = true;
                    donee = true;
                    donef = true;
                    doneg = true;
                    doneh = true;
                    donei = true;
                    donej = true;
                    donek = true;
                    donel = true;
                    donem = true;
                    donen = true;
                    doneo = true;
                    donep = true;
                    all1 = false;
                    all2 = false;
                    all3 = false;
                    all4 = false;
                    all5=false;
                    a = 6;
                    b = 6;
                    c = -6;
                    d = -6;
                    randomAnimalDrawn = false;
                    count = 0;
                    dx = 3;
                    dy = 0;
                    q = -100;
                    p = 100;
                    e=100;
                    invalidate();
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_DOWN && play) {
            startEx = (int) event.getX();
            startEy = (int) event.getY();
            invalidate();
        }
        if (action == MotionEvent.ACTION_DOWN) {
            cX = (int) event.getX();
            cY = (int) event.getY();
            invalidate();
        }
        if (action == MotionEvent.ACTION_DOWN && (homes || tort)) {
            mX = (int) event.getX();
            mY = (int) event.getY();
            invalidate();
        }
        if (action == MotionEvent.ACTION_DOWN && gameover) {
            sX = (int) event.getX();
            sY = (int) event.getY();
            invalidate();
        }


        if (action == MotionEvent.ACTION_UP) {
            sX=-1; sY=-1;mX=-1;mY=-1;cX=-1;cY=-1;look=true;
            endEx = (int) event.getX();
            endEy = (int) event.getY();
            int xSpeed=endEx - startEx;
            int ySpeed=endEy - startEy;
            if (Math.abs(xSpeed)>Math.abs(ySpeed)){
                if(Math.abs(xSpeed)==xSpeed) dir=2;
                else dir=4;
            } else
            if(Math.abs(ySpeed)==ySpeed) dir=3;
            else dir=1;

            invalidate();
        }
        invalidate();
        return true;
    }
}
