import { Box, Button, Container, Typography } from '@mui/material'
import axios from 'axios'
import { useState } from 'react'
import './App.css'

function App() {
  const [cueCard, setCueCard] = useState('')
  const [error, setError] = useState(null)

  const handleGetCueCard = async () => {
    try {
      setError(null) // Clear error before making request
      const res = await axios.get('http://192.168.29.224:8080/ccg/getCard')
      console.log('axios response:', res)
      setCueCard(res.data)
    } catch (err) {
      setError(err.message)
      console.error('axios error:', err)
    }
  }

  return (
    <Container
      maxWidth="sm"
      className="card"
      style={{ display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh' }}
    >
      <Box style={{ textAlign: 'center' }}>
        <Typography
          variant="body2"
          gutterBottom
          style={{
            whiteSpace: 'pre-wrap',
            fontFamily: 'Roboto Mono, monospace',
            fontSize: 16,
            visibility: cueCard ? 'visible' : 'hidden',
          }}
        >
          {cueCard}
        </Typography>
        <Button
          variant="contained"
          onClick={handleGetCueCard}
          style={{
            marginTop: 16,
            backgroundColor: '#00e676',
            color: 'white',
            fontSize: 12,
          }}
        >
          Get Cue Card
        </Button>
        {error && <Typography variant="body1" style={{ color: 'red' }}>{error}</Typography>}
      </Box>
    </Container>
  )
}

export default App

