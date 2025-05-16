import React, { useState } from 'react';

const Footer = () => {
  return (
    <footer style={styles.footer}>
      <div style={styles.container}>
        <p style={styles.text}><strong>Dietify</strong> — Your smart meal partner 🍏</p>
        <p style={styles.text}>© {new Date().getFullYear()} Dietify. All rights reserved.</p>
        <p style={styles.text}>
          Contact us: <a href="mailto:info@dietify.com" style={styles.link}>info@dietify.com</a> | 📞 +1 234 567 8901
        </p>
      </div>
    </footer>
  );
};

const styles = {
  footer: {
    backgroundColor: '#222',
    color: '#fff',
    padding: '20px 0',
    marginTop: '40px',
    textAlign: 'center',
  },
  container: {
    maxWidth: '800px',
    margin: '0 auto',
    padding: '0 20px',
  },
  text: {
    margin: '8px 0',
    fontSize: '14px',
  },
  link: {
    color: '#00d9ff',
    textDecoration: 'none',
  }
};

export default Footer;
