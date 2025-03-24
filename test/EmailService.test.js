const EmailService = require('../src/EmailService');
const MockEmailProvider = require('../src/MockEmailProvider');

describe('EmailService', () => {
    it('should send an email successfully', async () => {
        // Create mock providers
        const primaryProvider = new MockEmailProvider();
        const secondaryProvider = new MockEmailProvider();
        
        // Create instance of EmailService with mock providers
        const emailService = new EmailService(primaryProvider, secondaryProvider);

        // Call sendEmail
        await emailService.sendEmail(
            'test-id',
            'test@gmail.com',
            'Test Subject',
            'Test Body'
        );

        // Check the status log
        const statusLog = emailService.getStatusLog();
        expect(statusLog.length).toBe(1);
        expect(statusLog[0].status).toBe('sent');
        expect(statusLog[0].to).toBe('test@gmail.com');
        expect(statusLog[0].subject).toBe('Test Subject');
        expect(statusLog[0].body).toBe('Test Body');
    });

    it('should retry and fall back to secondary provider on failure', async () => {
        // Create mock providers
        const primaryProvider = new MockEmailProvider();
        const secondaryProvider = new MockEmailProvider();
        
        // Mock the send method of the primary provider to always fail
        jest.spyOn(primaryProvider, 'send').mockImplementation(() => {
            throw new Error('Primary provider failure');
        });

        // Mock the send method of the secondary provider to succeed
        jest.spyOn(secondaryProvider, 'send').mockImplementation(() => {
            // Optionally, log to verify fallback provider was used
            console.log('Fallback provider used.');
        });

        // Create instance of EmailService with mock providers
        const emailService = new EmailService(primaryProvider, secondaryProvider);

        // Call sendEmail
        await emailService.sendEmail(
            'test-id',
            'test@gmail.com',
            'Test Subject',
            'Test Body'
        );

        // Check the status log
        const statusLog = emailService.getStatusLog();
        expect(statusLog.length).toBe(1);
        expect(statusLog[0].status).toBe('sent');
        expect(statusLog[0].to).toBe('test@gmail.com');
        expect(statusLog[0].subject).toBe('Test Subject');
        expect(statusLog[0].body).toBe('Test Body');
    }, 50000); // Increase timeout for this test if needed
});
