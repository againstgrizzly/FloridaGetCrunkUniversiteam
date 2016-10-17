using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace DragDropUI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        double m_MouseX;
        double m_MouseY;

        public MainWindow()
        {
            InitializeComponent();
            button1.PreviewMouseUp += new MouseButtonEventHandler(button1_MouseUp);
            button1.PreviewMouseLeftButtonDown += new MouseButtonEventHandler(button1_MouseLeftButtonDown);
            button1.PreviewMouseMove += new MouseEventHandler(button1_MouseMove);
            button2.PreviewMouseUp += new MouseButtonEventHandler(button2_MouseUp);
            button2.PreviewMouseLeftButtonDown += new MouseButtonEventHandler(button2_MouseLeftButtonDown);
            button2.PreviewMouseMove += new MouseEventHandler(button2_MouseMove);
            button3.PreviewMouseUp += new MouseButtonEventHandler(button3_MouseUp);
            button3.PreviewMouseLeftButtonDown += new MouseButtonEventHandler(button3_MouseLeftButtonDown);
            button3.PreviewMouseMove += new MouseEventHandler(button3_MouseMove);
        }

        private void button1_MouseLeftButtonDown(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            m_MouseX = e.GetPosition(this).X;
            m_MouseY = e.GetPosition(this).Y;
        }

        private void button1_MouseMove(object sender, System.Windows.Input.MouseEventArgs e)
        {
            if (e.LeftButton == MouseButtonState.Pressed)
            {
                // Capture the mouse for border
                e.MouseDevice.Capture(button1);
                System.Windows.Thickness _margin = new System.Windows.Thickness();
                int _tempX = Convert.ToInt32(e.GetPosition(this).X);
                int _tempY = Convert.ToInt32(e.GetPosition(this).Y);
                _margin = mainGrid.Margin;
                // when While moving _tempX get greater than m_MouseX relative to usercontrol 
                if (m_MouseX > _tempX)
                {
                    // add the difference of both to Left
                    _margin.Left += (_tempX - m_MouseX);
                    // subtract the difference of both to Left
                    _margin.Right -= (_tempX - m_MouseX);
                }
                else
                {
                    _margin.Left -= (m_MouseX - _tempX);
                    _margin.Right -= (_tempX - m_MouseX);
                }
                if (m_MouseY > _tempY)
                {
                    _margin.Top += (_tempY - m_MouseY);
                    _margin.Bottom -= (_tempY - m_MouseY);
                }
                else
                {
                    _margin.Top -= (m_MouseY - _tempY);
                    _margin.Bottom -= (_tempY - m_MouseY);
                }
                mainGrid.Margin = _margin;
                m_MouseX = _tempX;
                m_MouseY = _tempY;
            }
        }
        private void button1_MouseUp(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            e.MouseDevice.Capture(null);
        }

        private void button2_MouseLeftButtonDown(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            m_MouseX = e.GetPosition(this).X;
            m_MouseY = e.GetPosition(this).Y;
        }

        private void button2_MouseMove(object sender, System.Windows.Input.MouseEventArgs e)
        {
            if (e.LeftButton == MouseButtonState.Pressed)
            {
                // Capture the mouse for border
                e.MouseDevice.Capture(button2);
                System.Windows.Thickness _margin = new System.Windows.Thickness();
                int _tempX = Convert.ToInt32(e.GetPosition(this).X);
                int _tempY = Convert.ToInt32(e.GetPosition(this).Y);
                _margin = mainGrid.Margin;
                // when While moving _tempX get greater than m_MouseX relative to usercontrol 
                if (m_MouseX > _tempX)
                {
                    // add the difference of both to Left
                    _margin.Left += (_tempX - m_MouseX);
                    // subtract the difference of both to Left
                    _margin.Right -= (_tempX - m_MouseX);
                }
                else
                {
                    _margin.Left -= (m_MouseX - _tempX);
                    _margin.Right -= (_tempX - m_MouseX);
                }
                if (m_MouseY > _tempY)
                {
                    _margin.Top += (_tempY - m_MouseY);
                    _margin.Bottom -= (_tempY - m_MouseY);
                }
                else
                {
                    _margin.Top -= (m_MouseY - _tempY);
                    _margin.Bottom -= (_tempY - m_MouseY);
                }
                mainGrid.Margin = _margin;
                m_MouseX = _tempX;
                m_MouseY = _tempY;
            }
        }

        private void button2_MouseUp(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            e.MouseDevice.Capture(null);
        }

        private void button3_MouseLeftButtonDown(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            m_MouseX = e.GetPosition(this).X;
            m_MouseY = e.GetPosition(this).Y;
        }

        private void button3_MouseMove(object sender, System.Windows.Input.MouseEventArgs e)
        {
            if (e.LeftButton == MouseButtonState.Pressed)
            {
                // Capture the mouse for border
                e.MouseDevice.Capture(button3);
                System.Windows.Thickness _margin = new System.Windows.Thickness();
                int _tempX = Convert.ToInt32(e.GetPosition(this).X);
                int _tempY = Convert.ToInt32(e.GetPosition(this).Y);
                _margin = mainGrid.Margin;
                // when While moving _tempX get greater than m_MouseX relative to usercontrol 
                if (m_MouseX > _tempX)
                {
                    // add the difference of both to Left
                    _margin.Left += (_tempX - m_MouseX);
                    // subtract the difference of both to Left
                    _margin.Right -= (_tempX - m_MouseX);
                }
                else
                {
                    _margin.Left -= (m_MouseX - _tempX);
                    _margin.Right -= (_tempX - m_MouseX);
                }
                if (m_MouseY > _tempY)
                {
                    _margin.Top += (_tempY - m_MouseY);
                    _margin.Bottom -= (_tempY - m_MouseY);
                }
                else
                {
                    _margin.Top -= (m_MouseY - _tempY);
                    _margin.Bottom -= (_tempY - m_MouseY);
                }
                mainGrid.Margin = _margin;
                m_MouseX = _tempX;
                m_MouseY = _tempY;
            }
        }

        private void button3_MouseUp(object sender, System.Windows.Input.MouseButtonEventArgs e)
        {
            e.MouseDevice.Capture(null);
        }
    }
}
