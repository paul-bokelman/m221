package com.example.sping_portfolio.controllers.asciiart;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public final class Picture implements ActionListener {
    private BufferedImage image;
    private JFrame frame;
    private String filename;
    private boolean isOriginUpperLeft = true;
    private final int width;
    private final int height;

    public Picture(int width, int height) {
        if (width <= 0) {
            throw new IllegalArgumentException("width must be positive");
        } else if (height <= 0) {
            throw new IllegalArgumentException("height must be positive");
        } else {
            this.width = width;
            this.height = height;
            this.image = new BufferedImage(width, height, 1);
        }
    }

    public Picture(Picture picture) {
        if (picture == null) {
            throw new IllegalArgumentException("constructor argument is null");
        } else {
            this.width = picture.width();
            this.height = picture.height();
            this.image = new BufferedImage(this.width, this.height, 1);
            this.filename = picture.filename;
            this.isOriginUpperLeft = picture.isOriginUpperLeft;

            for(int col = 0; col < this.width(); ++col) {
                for(int row = 0; row < this.height(); ++row) {
                    this.image.setRGB(col, row, picture.image.getRGB(col, row));
                }
            }

        }
    }

    public Picture(String name) {
        if (name == null) {
            throw new IllegalArgumentException("constructor argument is null");
        } else {
            this.filename = name;

            try {
                File file = new File(name);
                if (file.isFile()) {
                    this.image = ImageIO.read(file);
                } else {
                    URL url = this.getClass().getResource(this.filename);
                    if (url == null) {
                        url = this.getClass().getClassLoader().getResource(name);
                    }

                    if (url == null) {
                        url = new URL(name);
                    }

                    this.image = ImageIO.read(url);
                }

                if (image == null) {
                    throw new IllegalArgumentException("could not read image: " + name);
                } else {
                    width = image.getWidth(null);
                    height = image.getHeight(null);
                }
            } catch (IOException var4) {
                throw new IllegalArgumentException("could not open image: " + name, var4);
            }
        }
    }

    public Picture(File file) {
        if (file == null) {
            throw new IllegalArgumentException("constructor argument is null");
        } else {
            try {
                this.image = ImageIO.read(file);
            } catch (IOException var3) {
                throw new IllegalArgumentException("could not open file: " + file, var3);
            }

            if (image == null) {
                throw new IllegalArgumentException("could not read file: " + file);
            } else {
                width = image.getWidth(null);
                height = image.getHeight(null);
                this.filename = file.getName();
            }
        }
    }

    public JLabel getJLabel() {
        if (image == null) {
            return null;
        } else {
            ImageIcon icon = new ImageIcon(this.image);
            return new JLabel(icon);
        }
    }

    public void setOriginUpperLeft() {
        this.isOriginUpperLeft = true;
    }

    public void setOriginLowerLeft() {
        this.isOriginUpperLeft = false;
    }

    public void show() {
        if (this.frame == null) {
            this.frame = new JFrame();
            JMenuBar menuBar = new JMenuBar();
            JMenu menu = new JMenu("File");
            menuBar.add(menu);
            JMenuItem menuItem1 = new JMenuItem(" Save...   ");
            menuItem1.addActionListener(this);
            menuItem1.setAccelerator(KeyStroke.getKeyStroke(83, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            menu.add(menuItem1);
            this.frame.setJMenuBar(menuBar);
            this.frame.setContentPane(this.getJLabel());
            this.frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            if (this.filename == null) {
                this.frame.setTitle(this.width + "-by-" + this.height);
            } else {
                this.frame.setTitle(this.filename);
            }

            this.frame.setResizable(false);
            this.frame.pack();
            this.frame.setVisible(true);
        }

        this.frame.repaint();
    }

    public int height() {
        return this.height;
    }

    public int width() {
        return this.width;
    }

    private void validateRowIndex(int row) {
        if (row < 0 || row >= this.height()) {
            int var10002 = this.height() - 1;
            throw new IllegalArgumentException("row index must be between 0 and " + var10002 + ": " + row);
        }
    }

    private void validateColumnIndex(int col) {
        if (col < 0 || col >= this.width()) {
            int var10002 = this.width() - 1;
            throw new IllegalArgumentException("column index must be between 0 and " + var10002 + ": " + col);
        }
    }


    public Color get(int col, int row) {
        this.validateColumnIndex(col);
        this.validateRowIndex(row);
        int rgb = this.getRGB(col, row);
        return new Color(rgb);
    }

    public int getRGB(int col, int row) {
        this.validateColumnIndex(col);
        this.validateRowIndex(row);
        return this.isOriginUpperLeft ? this.image.getRGB(col, row) : this.image.getRGB(col, this.height - row - 1);
    }

    public void set(int col, int row, Color color) {
        this.validateColumnIndex(col);
        this.validateRowIndex(row);
        if (color == null) {
            throw new IllegalArgumentException("color argument is null");
        } else {
            int rgb = color.getRGB();
            this.setRGB(col, row, rgb);
        }
    }

    public void setRGB(int col, int row, int rgb) {
        this.validateColumnIndex(col);
        this.validateRowIndex(row);
        if (this.isOriginUpperLeft) {
            this.image.setRGB(col, row, rgb);
        } else {
            this.image.setRGB(col, this.height - row - 1, rgb);
        }

    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        } else if (other == null) {
            return false;
        } else if (other.getClass() != this.getClass()) {
            return false;
        } else {
            Picture that = (Picture)other;
            if (this.width() != that.width()) {
                return false;
            } else if (this.height() != that.height()) {
                return false;
            } else {
                for(int col = 0; col < this.width(); ++col) {
                    for(int row = 0; row < this.height(); ++row) {
                        if (this.getRGB(col, row) != that.getRGB(col, row)) {
                            return false;
                        }
                    }
                }

                return true;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.width + "-by-" + this.height + " picture (RGB values given in hex)\n");

        for(int row = 0; row < this.height; ++row) {
            for(int col = 0; col < this.width; ++col) {
                int rgb = 0;
                if (this.isOriginUpperLeft) {
                    rgb = this.image.getRGB(col, row);
                } else {
                    rgb = this.image.getRGB(col, this.height - row - 1);
                }

                sb.append(String.format("#%06X ", rgb & 16777215));
            }

            sb.append("\n");
        }

        return sb.toString().trim();
    }

    public int hashCode() {
        throw new UnsupportedOperationException("hashCode() is not supported because pictures are mutable");
    }

    public void save(String name) {
        if (name == null) {
            throw new IllegalArgumentException("argument to save() is null");
        } else {
            this.save(new File(name));
            this.filename = name;
        }
    }

    public void save(File file) {
        if (file == null) {
            throw new IllegalArgumentException("argument to save() is null");
        } else {
            this.filename = file.getName();
            if (this.frame != null) {
                this.frame.setTitle(this.filename);
            }

            String suffix = this.filename.substring(this.filename.lastIndexOf(46) + 1);
            if (!"jpg".equalsIgnoreCase(suffix) && !"png".equalsIgnoreCase(suffix)) {
                System.out.println("Error: filename must end in .jpg or .png");
            } else {
                try {
                    ImageIO.write(this.image, suffix, file);
                } catch (IOException var4) {
                    var4.printStackTrace();
                }
            }

        }
    }

    public void actionPerformed(ActionEvent e) {
        FileDialog chooser = new FileDialog(this.frame, "Use a .png or .jpg extension", 1);
        chooser.setVisible(true);
        if (chooser.getFile() != null) {
            String var10001 = chooser.getDirectory();
            this.save(var10001 + File.separator + chooser.getFile());
        }

    }

    public static void main(String[] args) {
        Picture picture = new Picture("pumpkin.png");
        System.out.printf("%d-by-%d\n", picture.width(), picture.height());
        picture.show();
    }
}
