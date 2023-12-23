export class Image {
    url!: string;
    height!: number;
    width!: number;

    constructor(data: Image) {
        this.url = data.url;
        this.height = data.height;
        this.width = data.width;
      }
  }