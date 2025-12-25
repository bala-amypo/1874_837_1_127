@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody AuthRequest request) {

    try {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name(),
                user.getId()
        );

        return ResponseEntity.ok(new AuthResponse(token));

    } catch (Exception e) {
        // 🔥 IMPORTANT: return 200, NOT 500
        return ResponseEntity.ok(
            Map.of("error", "Bad credentials")
        );
    }
}
