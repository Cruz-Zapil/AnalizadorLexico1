package com.leng.analizador.frontEnd.graficos;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GraphvizSwingExample extends JFrame {

    private JPanel graphPanel;

    public GraphvizSwingExample() {
        setTitle("Graphviz Swing Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        graphPanel = new JPanel();
        add(graphPanel);

        generateAndDisplayGraph();
    }

    private void generateAndDisplayGraph() {
        try {
            // Replace "dotPath" with the path to your Graphviz "dot" executable
            String dotPath = "path/to/dot/executable";
            String dotSource = "digraph G { a -> b; }"; // Example DOT source

            ProcessBuilder processBuilder = new ProcessBuilder(dotPath, "-Tpng");
            Process process = processBuilder.start();

            try (OutputStream outputStream = process.getOutputStream();
                 InputStream inputStream = process.getInputStream()) {
                outputStream.write(dotSource.getBytes());
                outputStream.close();

                ImageIcon imageIcon = new ImageIcon(inputStream.readAllBytes());
                JLabel imageLabel = new JLabel(imageIcon);
                graphPanel.add(imageLabel);

                // Refresh the panel to display the image
                graphPanel.revalidate();
                graphPanel.repaint();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GraphvizSwingExample example = new GraphvizSwingExample();
            example.setVisible(true);
        });
    }
}
