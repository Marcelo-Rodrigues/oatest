import { OatestPage } from './app.po';

describe('oatest App', () => {
  let page: OatestPage;

  beforeEach(() => {
    page = new OatestPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to my!');
  });
});
