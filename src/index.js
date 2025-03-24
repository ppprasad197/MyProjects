const EmailService = require('./EmailService');
const MockEmailProvider = require('./MockEmailProvider');

const primaryProvider = new MockEmailProvider();
const secondaryProvider = new MockEmailProvider();

const emailService = new EmailService(primaryProvider, secondaryProvider);

async function run() {
    try {
        await emailService.sendEmail(
            `unique-id-${Date.now()}`,
            'test@gmail.com',
            'Test Subject',
            'Test Body'
        );
        console.log('Email sent successfully');
    } catch (error) {
        console.error(`Failed to send email: ${error.message}`);
    }

    console.log('Status log:', emailService.getStatusLog());
}

run();
